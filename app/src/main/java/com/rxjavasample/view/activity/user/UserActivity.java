package com.rxjavasample.view.activity.user;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import com.rxjavasample.R;
import com.rxjavasample.base.BaseActivity;
import com.rxjavasample.constants.AppConstants;
import com.rxjavasample.view.fragment.about.AboutFragment;
import com.rxjavasample.view.fragment.followers.FollowersFragment;
import com.rxjavasample.view.fragment.repos.ReposFragment;
import com.rxjavasample.view.viewholder.DrawerHeaderViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserActivity extends BaseActivity implements UserView {
    private UserPresenter mPresenter;
    private DrawerHeaderViewHolder mDrawerHeader;
    private Handler mHandler = new Handler();

    private AboutFragment mAboutFragment;
    private ReposFragment mReposFragment;
    private FollowersFragment mFollowersFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);

        setPresenter();
    }

    @Override
    public void onBackPressed() {
        if (mPresenter.onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override
    public void setPresenter() {
        super.setPresenter(mPresenter = new UserPresenterImpl(getComponent(), this));
    }

    @Override
    public void setToolbar() {
        setSupportActionBar(mToolbar);
    }

    @Override
    public void initializeDrawerHeader() {
        mDrawerHeader = new DrawerHeaderViewHolder(getComponent(),
                mNavigationView.getHeaderView(0), view -> mPresenter.onClick(view.getId()));
    }

    @Override
    public void initializeNavigationView() {
        mNavigationView.setNavigationItemSelectedListener(
                item -> mPresenter.onNavigationItemSelected(item.getItemId())
        );
    }

    @Override
    public void setDrawerListener() {
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,
                mToolbar,
                R.string.open_drawer_description,
                R.string.close_drawer_description);

        mDrawerLayout.addDrawerListener(drawerToggle);

        // calling sync state is necessary or else your hamburger icon wont show up
        drawerToggle.syncState();
    }

    @Override
    public void setToolbarTitle(String title) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }

    @Override
    public void selectNavigationMenu(int index) {
        mNavigationView.getMenu()
                .getItem(index)
                .setChecked(true);
    }

    @Override
    public void setDrawerHeaderBackground(int resId, int placeHolderResId) {
        mDrawerHeader.setHeaderBackground(resId, placeHolderResId);
    }

    @Override
    public void setDrawerHeaderProfilePic(String url, int placeHolderResId) {
        mDrawerHeader.setProfilePic(url, placeHolderResId);
    }

    @Override
    public void setDrawerHeaderName(String name) {
        mDrawerHeader.setName(name);
    }

    @Override
    public void setDrawerHeaderProfileUrl(String profileUrl) {
        mDrawerHeader.setProfileUrl(profileUrl);
    }

    @Override
    public int getExtraUserId() {
        return getIntent().getIntExtra(AppConstants.EXTRA_USER_ID, -1);
    }

    @Override
    public boolean isDrawerOpen() {
        return mDrawerLayout.isDrawerOpen(GravityCompat.START);
    }

    @Override
    public void openOnBrowser(String url) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }

    @Override
    public void closeDrawer() {
        mDrawerLayout.closeDrawers();
    }

    @Override
    public void loadAboutFragment(int fragmentId, String tag, int userId) {
        if (mAboutFragment == null) {
            mAboutFragment = AboutFragment.newInstance(userId);
        }

        loadFragment(fragmentId, mAboutFragment, tag);
    }

    @Override
    public void loadReposFragment(int fragmentId, String tag, int userId) {
        if (mReposFragment == null) {
            mReposFragment = ReposFragment.newInstance(userId);
        }

        loadFragment(fragmentId, mReposFragment, tag);
    }

    @Override
    public void loadFollowersFragment(int fragmentId, String tag, int userId) {
        if (mFollowersFragment == null) {
            mFollowersFragment = FollowersFragment.newInstance(userId);
        }

        loadFragment(fragmentId, mFollowersFragment, tag);
    }

    private void loadFragment(final int fragmentId, final Fragment fragment, final String tag) {

        // Sometimes, when fragment has huge data, screen seems hanging
        // when switching between navigation menus
        // So using runnable, the fragment is loaded with cross fade effect
        // This effect can be seen in GMail app
        Runnable runnable = () -> {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            transaction.replace(fragmentId, fragment, tag);
            transaction.commitAllowingStateLoss();
        };

        mHandler.post(runnable);
    }

    @BindView(R.id.app_bar_user_activity_toolbar) Toolbar mToolbar;
    @BindView(R.id.activity_user_drawer_layout) DrawerLayout mDrawerLayout;
    @BindView(R.id.activity_user_nav_view) NavigationView mNavigationView;
}
