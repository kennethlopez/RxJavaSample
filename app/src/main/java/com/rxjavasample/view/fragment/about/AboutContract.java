package com.rxjavasample.view.fragment.about;


import com.rxjavasample.base.BaseView;

public interface AboutContract {

    interface View extends BaseView {

        void setProfilePic(String url);

        void setName(int labelResId, String name);

        void setProfileUrl(int labelResId, String profileUrl);

        void setLocation(int labelResId, String location);

        void setCompany(int labelResId, String company);

        void setRepos(int labelResId, String repos);

        void setFollowers(int labelResId, String followers);

        void setFollowing(int labelResId, String following);

        int getExtraUserId();

        void openOnBrowser(String url);
    }

    interface Presenter {

    }
}
