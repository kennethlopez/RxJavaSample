package com.rxjavasample.view.activity.home;


import android.util.Log;

import com.rxjavasample.R;
import com.rxjavasample.base.BasePresenter;
import com.rxjavasample.constants.NetworkConstants;
import com.rxjavasample.data.manger.UserDataManager;
import com.rxjavasample.injection.component.AppComponent;
import com.rxjavasample.util.MainUtil;
import com.rxjavasample.util.NetworkUtil;
import com.rxjavasample.util.RxBus;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter {
    @Inject
    transient UserDataManager mUserDataManager;
    @Inject
    transient RxBus mBus;

    private static final String TAG = "HomePresenterImpl";
    private CompositeDisposable mDisposables = new CompositeDisposable();

    HomePresenter(AppComponent appComponent, HomeContract.View view) {
        super(appComponent, view);
        appComponent.inject(this);

        getView().disableSearch();

        subscribeToSyncServiceEvent();
    }

    @Override
    protected void onDestroy() {
        mDisposables.clear();

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
    public void onTextChangedUsername(CharSequence charSequence, int start, int before, int count) {
        if (MainUtil.isValidUsername(String.valueOf(charSequence))) {
            getView().enableSearch();
        } else {
            getView().disableSearch();
        }
    }

    private void onClickSearch() {
        String username = getView().getUsername();

        if (!mUserDataManager.getDb().hasUser(username)) {
            getView().showProgressDialog(R.string.fetching_user_data_text);

            mDisposables.add(mUserDataManager.fetchUser(username)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(user -> onNext(), this::onError));

        } else getView().startUserListActivity();
    }

    private void subscribeToSyncServiceEvent() {
        Flowable<String> stringFlowable = mBus.filteredObservable(String.class);
        if (stringFlowable != null) {
            // log the posted event from SyncService
            mDisposables.add(stringFlowable
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(string -> Log.d(TAG, string)));
        }
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