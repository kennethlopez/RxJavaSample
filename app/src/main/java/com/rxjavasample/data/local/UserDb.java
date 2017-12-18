package com.rxjavasample.data.local;


import com.rxjavasample.base.BaseDb;
import com.rxjavasample.data.manger.RealmManager;
import com.rxjavasample.data.model.User;
import com.rxjavasample.data.model.fields.UserFields;

import io.realm.Case;

public class UserDb extends BaseDb<User> implements UserFields {

    public User getUser(final int userId) {
        return RealmManager.getRealm()
                .where(User.class)
                .equalTo(ID, userId)
                .findFirst();
    }

    public boolean hasUser(String username) {
        return RealmManager.getRealm()
                .where(User.class)
                .equalTo(LOGIN, username, Case.INSENSITIVE)
                .not()
                .findFirst() != null;
    }
}