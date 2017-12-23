package com.rxjavasample.view.fragment.about;


import com.rxjavasample.R;
import com.rxjavasample.base.BasePresenter;
import com.rxjavasample.data.manger.UserDataManager;
import com.rxjavasample.data.model.User;
import com.rxjavasample.injection.component.AppComponent;
import com.rxjavasample.util.MainUtil;
import com.rxjavasample.util.RxUtil;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;


public class AboutPresenter extends BasePresenter<AboutContract.View> implements AboutContract.Presenter {
    @Inject
    transient UserDataManager mUserDataManager;

    private Disposable mDisposable;
    private User mUser;

    AboutPresenter(AppComponent appComponent, AboutContract.View view) {
        super(appComponent, view);
        appComponent.inject(this);

        mDisposable = mUserDataManager.getDb()
                .getUserAsync(getView().getExtraUserId())
                .asFlowable()
                .filter(user -> user.isLoaded())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(realmObject -> updateUserFields(mUser = (User) realmObject));
    }

    @Override
    protected void onDestroy() {
        RxUtil.dispose(mDisposable);

        super.onDestroy();
    }

    @Override
    public void onClick(int viewId) {
        switch (viewId) {
            case R.id.fragment_about_profile_url:
                if (mUser != null) getView().openOnBrowser(mUser.getHtmlUrl());
                break;
        }
    }

    private void updateUserFields(final User user) {
        String none = "None";
        String name = !MainUtil.isEmpty(user.getName()) ? user.getName() : none;
        String location = !MainUtil.isEmpty(user.getLocation()) ? user.getLocation() : none;
        String company = !MainUtil.isEmpty(user.getCompany()) ? user.getCompany() : none;

        getView().setProfilePic(user.getAvatarUrl());
        getView().setName(R.string.name_colon_text, name);
        getView().setProfileUrl(R.string.github_profile_colon_text, user.getHtmlUrl());
        getView().setLocation(R.string.location_colon_text, location);
        getView().setCompany(R.string.company_colon_text, company);
        getView().setRepos(R.string.repos_colon_text, String.valueOf(user.getPublicRepos()));
        getView().setFollowers(R.string.followers_colon_text, String.valueOf(user.getFollowers()));
        getView().setFollowing(R.string.following_colon_text, String.valueOf(user.getFollowing()));
    }
}