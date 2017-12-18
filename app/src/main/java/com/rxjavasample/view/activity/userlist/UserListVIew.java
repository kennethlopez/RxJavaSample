package com.rxjavasample.view.activity.userlist;


import com.rxjavasample.base.BaseView;
import com.rxjavasample.data.model.User;

import java.util.List;

import io.realm.OrderedRealmCollection;

public interface UserListView extends BaseView {
    void initRecyclerView(OrderedRealmCollection<User> users);

    void startUserActivity(User user);
}
