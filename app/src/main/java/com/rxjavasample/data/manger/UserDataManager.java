package com.rxjavasample.data.manger;


import com.rxjavasample.base.BaseDataManager;
import com.rxjavasample.data.local.UserDb;
import com.rxjavasample.data.model.Follower;
import com.rxjavasample.data.model.User;


import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import retrofit2.Retrofit;

public class UserDataManager extends BaseDataManager<UserDb> {

    public UserDataManager(Retrofit retrofit, UserDb db) {
        super(retrofit, db);
    }

    public Flowable<User> syncUsers(Realm realm) {
        return getDb().getAllAsRealmResultsAsync(User.class, realm)
                .asFlowable()
                .filter(RealmResults::isLoaded)
                .switchMap(Flowable::fromIterable)
                .flatMap(user -> fetchUser(user.getLogin()));
    }

    public Flowable<User> fetchUser(String username) {
        Flowable<User> userFlowable = getApi().getUser(username);
        Flowable<List<Follower>> followersFlowable = getApi().getFollowers(username);

        return userFlowable.zipWith(followersFlowable, (user, followers) -> {
            Follower[] followerArray = followers.toArray(new Follower[followers.size()]);
            user.setFollowersList(new RealmList<>(followerArray));
            return user;
        })
                .doOnNext(user -> getDb().updateOrSave(user))
                // to make sure that api requests are invoked on a worker thread
                .subscribeOn(Schedulers.io());
    }
}