package com.rxjavasample.view.activity.user;



import com.rxjavasample.R;
import com.rxjavasample.data.manger.UserDataManager;
import com.rxjavasample.data.model.User;
import com.rxjavasample.injection.component.AppComponent;
import com.rxjavasample.util.MainUtil;

import javax.inject.Inject;


public class UserPresenterImpl extends UserPresenter implements UserView.MenuItemIndexes,
        UserView.FragmentTags {
    @Inject
    transient UserDataManager mUserDataManager;

    private final String[] mToolbarTitles;
    private User mUser;
    private String mFragmentTag = "";

    UserPresenterImpl(AppComponent appComponent, UserView view) {
        super(appComponent, view);
        appComponent.inject(this);

        mToolbarTitles = MainUtil.getStringArray(appComponent.context(),
                R.array.user_fragment_toolbar_title);

        mUser = mUserDataManager.getDb().getUser(getView().getExtraUserId());

        getView().setToolbar();
        getView().initializeNavigationView();
        getView().initializeDrawerHeader();
        getView().setDrawerListener();
        getView().setDrawerHeaderBackground(R.drawable.bg_nav_header, R.mipmap.ic_launcher);

        updateUserFields();
        loadFragment(FRAGMENT_ABOUT);
    }

    @Override
    public void onClick(int viewId) {
        switch (viewId) {
            case R.id.nav_header_user_activity_profile_url:
                getView().openOnBrowser(mUser.getHtmlUrl());
                break;
        }
    }

    @Override
    protected boolean onBackPressed() {
        if (getView().isDrawerOpen()) {
            getView().closeDrawer();
            return false;
        }

        return true;
    }

    @Override
    protected boolean onNavigationItemSelected(int menuItemId) {
        String fragmentTag;

        switch (menuItemId) {
            default:
            case R.id.menu_user_drawer_about:
                fragmentTag = FRAGMENT_ABOUT;
                break;
            case R.id.menu_user_drawer_repos:
                fragmentTag = FRAGMENT_REPOS;
                break;
            case R.id.menu_user_drawer_followers:
                fragmentTag = FRAGMENT_FOLLOWERS;
                break;
        }

        if (!mFragmentTag.contentEquals(fragmentTag)) {
            mFragmentTag = fragmentTag;
            loadFragment(fragmentTag);
        }

        getView().closeDrawer();

        return true;
    }

    private void updateUserFields() {
        getView().setDrawerHeaderName(mUser.getName());
        getView().setDrawerHeaderProfilePic(mUser.getAvatarUrl(), R.drawable.ic_person_black_24dp);
        getView().setDrawerHeaderProfileUrl(mUser.getHtmlUrl());
    }

    private void loadFragment(String fragmentTag) {
        int index;
        int fragmentId = R.id.app_bar_user_activity_frame;
        int userId = mUser.getId();

        switch (fragmentTag) {
            default:
            case FRAGMENT_ABOUT:
                index = MENU_ITEM_ABOUT_INDEX;
                getView().loadAboutFragment(fragmentId, fragmentTag, userId);
                break;
            case FRAGMENT_REPOS:
                index = MENU_ITEM_RESPOS_INDEX;
                getView().loadReposFragment(fragmentId, fragmentTag, userId);
                break;
            case FRAGMENT_FOLLOWERS:
                index = MENU_ITEM_FOLLOWERS_INDEX;
                getView().loadFollowersFragment(fragmentId, fragmentTag, userId);
                break;
        }

        getView().selectNavigationMenu(index);
        getView().setToolbarTitle(mToolbarTitles[index]);
    }
}