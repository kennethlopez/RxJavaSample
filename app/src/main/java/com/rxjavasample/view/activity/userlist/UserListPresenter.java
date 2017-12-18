package com.rxjavasample.view.activity.userlist;


import com.rxjavasample.base.BasePresenter;
import com.rxjavasample.data.model.User;
import com.rxjavasample.injection.component.AppComponent;

public abstract class UserListPresenter extends BasePresenter<UserListView> {

    public UserListPresenter(AppComponent appComponent, UserListView view) {
        super(appComponent, view);
    }

    public abstract void onRecyclerViewItemClick(User user);
}
