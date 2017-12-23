package com.rxjavasample.view.activity.userlist;


import com.rxjavasample.base.BasePresenter;
import com.rxjavasample.data.manger.UserDataManager;
import com.rxjavasample.data.model.User;
import com.rxjavasample.injection.component.AppComponent;

import javax.inject.Inject;


public class UserListPresenter extends BasePresenter<UserListContract.View> implements
        UserListContract.Presenter {
    @Inject
    transient UserDataManager mUserDataManager;

    UserListPresenter(AppComponent appComponent, UserListContract.View view) {
        super(appComponent, view);
        appComponent.inject(this);

        getView().initRecyclerView(mUserDataManager.getDb()
                .getAllAsOrderedRealmCollectionAsync(User.class));
    }

    @Override
    public void onRecyclerViewItemClick(User user) {
        getView().startUserActivity(user);
    }
}