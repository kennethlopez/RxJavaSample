package com.rxjavasample.view.activity.user;


import com.rxjavasample.base.BasePresenter;
import com.rxjavasample.injection.component.AppComponent;

public abstract class UserPresenter extends BasePresenter<UserView> {
    public UserPresenter(AppComponent appComponent, UserView view) {
        super(appComponent, view);
    }

    protected abstract boolean onBackPressed();

    protected abstract boolean onNavigationItemSelected(int menuItemId);
}