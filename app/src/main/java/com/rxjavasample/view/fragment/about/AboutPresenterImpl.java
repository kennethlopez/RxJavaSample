package com.rxjavasample.view.fragment.about;


import com.rxjavasample.R;
import com.rxjavasample.data.manger.UserDataManager;
import com.rxjavasample.data.model.User;
import com.rxjavasample.injection.component.AppComponent;
import com.rxjavasample.util.MainUtil;

import javax.inject.Inject;


public class AboutPresenterImpl extends AboutPresenter {
    @Inject
    transient UserDataManager mUserDataManager;

    private User mUser;

    AboutPresenterImpl(AppComponent appComponent, AboutView view) {
        super(appComponent, view);
        appComponent.inject(this);

        mUser = mUserDataManager.getDb().getUser(getView().getExtraUserId());
        updateUserFields();
    }

    @Override
    public void onClick(int viewId) {
        switch (viewId) {
            case R.id.fragment_about_profile_url:
                getView().openOnBrowser(mUser.getHtmlUrl());
                break;
        }
    }

    private void updateUserFields() {
        getView().setProfilePic(mUser.getAvatarUrl());
        getView().setName(R.string.name_colon_text, mUser.getName());
        getView().setProfileUrl(R.string.github_profile_colon_text, mUser.getHtmlUrl());
        getView().setRepos(R.string.repos_colon_text, String.valueOf(mUser.getPublicRepos()));
        getView().setFollowers(R.string.followers_colon_text, String.valueOf(mUser.getFollowers()));
        getView().setFollowing(R.string.following_colon_text, String.valueOf(mUser.getFollowing()));

        String location = mUser.getLocation();
        if (MainUtil.isEmpty(location)) {
            location = "None";
        }
        getView().setLocation(R.string.location_colon_text, location);

        String company = mUser.getCompany();
        if (MainUtil.isEmpty(company)) {
            company = "None";
        }
        getView().setCompany(R.string.company_colon_text, company);
    }
}