package com.rxjavasample.view.activity.userlist;


import com.rxjavasample.base.BaseView;
import com.rxjavasample.data.model.User;

import io.realm.OrderedRealmCollection;

public interface UserListContract {
    interface View extends BaseView {
        void initRecyclerView(OrderedRealmCollection<User> users);

        void startUserActivity(User user);
    }

    interface Presenter {
        void onRecyclerViewItemClick(User user);
    }
}
