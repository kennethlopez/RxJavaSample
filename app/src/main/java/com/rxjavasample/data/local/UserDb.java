package com.rxjavasample.data.local;


import com.rxjavasample.base.BaseDb;
import com.rxjavasample.data.model.User;
import com.rxjavasample.data.model.fields.UserFields;

import io.realm.Case;

public class UserDb extends BaseDb<User> implements UserFields {

    public User getUserAsync(final int userId) {
        return getRealm().where(User.class)
                .equalTo(ID, userId)
                .findFirstAsync();
    }

    public boolean hasUser(final String username) {
        return getRealm().where(User.class)
                .equalTo(LOGIN, username, Case.INSENSITIVE)
                .not()
                .findFirst() != null;
    }
}