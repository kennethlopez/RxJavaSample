package com.rxjavasample.view.activity.home;


import android.util.Log;

import com.rxjavasample.R;
import com.rxjavasample.constants.NetworkConstants;
import com.rxjavasample.data.manger.UserDataManager;
import com.rxjavasample.injection.component.AppComponent;
import com.rxjavasample.util.MainUtil;
import com.rxjavasample.util.NetworkUtil;
import com.rxjavasample.util.RxBus;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class HomePresenterImpl extends HomePresenter {
    @Inject
    transient UserDataManager mUserDataManager;
    @Inject
    transient RxBus mBus;

    private static final String TAG = "HomePresenterImpl";

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    HomePresenterImpl(AppComponent appComponent, HomeView view) {
        super(appComponent, view);
        appComponent.inject(this);

        getView().disableSearch();
        getView().startSyncService();

        logPostedEventFromSyncService();
    }

    @Override
    protected void onDestroy() {
        mCompositeDisposable.clear();

        super.onDestroy();
    }

    @Override
    public void onClick(int viewId) {
        switch (viewId) {
            case R.id.activity_main_search:
                onClickSearch();
                break;
        }
    }

    @Override
    protected void onTextChangedUsername(CharSequence charSequence, int start, int before, int count) {
        if (MainUtil.isValidUsername(String.valueOf(charSequence))) {
            getView().enableSearch();
        } else {
            getView().disableSearch();
        }
    }

    private void logPostedEventFromSyncService() {
        // log the posted event from SyncService
        mCompositeDisposable.add(mBus.filteredObservable(String.class)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(string -> Log.d(TAG, string)));
    }

    private void onClickSearch() {
        String username = getView().getUsername();

        if (!mUserDataManager.getDb().hasUser(username)) {
            getView().showProgressDialog(R.string.fetching_user_data_text);

             mCompositeDisposable.add(mUserDataManager.fetchUser(username)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(user -> onNext(), this::onError));

        } else getView().startUserListActivity();
    }

    private void onNext() {
        getView().hideProgressDialog();
        getView().toastMessage(R.string.fetched_user_data_message);
        getView().startUserListActivity();
    }

    private void onError(Throwable throwable) {
        getView().hideProgressDialog();

        if (!NetworkUtil.isConnectionError(throwable)) {
            switch (NetworkUtil.getHttpExceptionErrorCode(throwable)) {
                default:
                case NetworkConstants.NOT_HTTPEXCEPTION:
                    getView().toastMessage(R.string.problem_saving_user_error_message);
                    throwable.printStackTrace();
                    break;
                case NetworkConstants.NOT_FOUND_404:
                    getView().toastMessage(R.string.user_not_found);
                    break;
            }
        } else getView().showConnectionErrorDialog(R.string.error_522);
    }
}