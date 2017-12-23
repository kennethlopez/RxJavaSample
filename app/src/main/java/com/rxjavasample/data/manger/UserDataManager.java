package com.rxjavasample.data.manger;


import com.rxjavasample.base.BaseDataManager;
import com.rxjavasample.data.local.UserDb;
import com.rxjavasample.data.model.Follower;
import com.rxjavasample.data.model.User;
import com.rxjavasample.data.remote.ApiService;


import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class UserDataManager extends BaseDataManager<UserDb> {

    public UserDataManager(ApiService apiService, UserDb db) {
        super(apiService, db);
    }

    public Flowable<User> syncUsers() {
        return getDb().getAllAsList(User.class)
                .switchMap(Flowable::fromIterable)
                .flatMap(user -> fetchUser(user.getLogin()));
    }

    public Flowable<User> fetchUser(final String username) {
        return getApiService().getUser(username)
                .subscribeOn(Schedulers.io())
                .zipWith(getApiService().getFollowers(username).subscribeOn(Schedulers.io()),
                        ((User user, List<Follower> followers) -> {
                            Follower[] followerArray = followers.toArray(new Follower[followers.size()]);
                            user.setFollowersList(new RealmList<>(followerArray));
                            return user;
                        }))
                .switchMap(user -> getDb().updateOrSave(user));
    }
}