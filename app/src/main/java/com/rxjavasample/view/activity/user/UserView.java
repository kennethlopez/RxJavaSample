package com.rxjavasample.view.activity.user;


import com.rxjavasample.base.BaseView;

interface UserView extends BaseView {
    interface FragmentTags {
        String FRAGMENT_ABOUT = "FRAGMENT_ABOUT";
        String FRAGMENT_REPOS = "FRAGMENT_REPOS";
        String FRAGMENT_FOLLOWERS = "FRAGMENT_FOLLOWERS";
    }

    interface MenuItemIndexes {
        int MENU_ITEM_ABOUT_INDEX = 0;
        int MENU_ITEM_RESPOS_INDEX = 1;
        int MENU_ITEM_FOLLOWERS_INDEX = 2;
    }

    void setToolbar();

    void initializeDrawerHeader();

    void initializeNavigationView();

    void setDrawerListener();

    void setToolbarTitle(String title);

    void selectNavigationMenu(int index);

    void setDrawerHeaderBackground(int resId, int placeHolderResId);

    void setDrawerHeaderProfilePic(String url, int placeHolderResId);

    void setDrawerHeaderName(String name);

    void setDrawerHeaderProfileUrl(String profileUrl);

    int getExtraUserId();

    boolean isDrawerOpen();

    void openOnBrowser(String url);

    void closeDrawer();

    void loadAboutFragment(int fragmentId, String tag, int userId);

    void loadReposFragment(int fragmentId, String tag, int userId);

    void loadFollowersFragment(int fragmentId, String tag, int userId);
}
