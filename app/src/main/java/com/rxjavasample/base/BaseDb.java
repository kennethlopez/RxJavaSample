package com.rxjavasample.base;

import com.rxjavasample.data.manger.RealmManager;

import java.util.List;

import javax.annotation.Nonnull;

import io.reactivex.Flowable;
import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmObject;

public class BaseDb<T extends RealmObject> {

    private Realm realm;

    protected void setRealm(@Nonnull final Realm realm) {
        this.realm = realm;
    }

    protected Realm getRealm() {
        // initialize realm to UI thread realm null
        if (realm == null) realm = RealmManager.getRealm();
        return realm;
    }

    public int count(Class<T> clazz) {
        return getRealm().where(clazz)
                .findAll()
                .size();
    }

    public Flowable<T> updateOrSave(T data) {
        try (Realm realm = Realm.getDefaultInstance() ) {
            realm.executeTransaction(realmCopy -> realmCopy.copyToRealmOrUpdate(data));
            return Flowable.just(data);
        }
    }

    public Flowable<List<T>> getAllAsList(Class<T> clazz) {
        List<T> users = getRealm().where(clazz).findAll();
        return Flowable.just(users);
    }

    public OrderedRealmCollection<T> getAllAsOrderedRealmCollectionAsync(Class<T> clazz) {
        return getRealm().where(clazz)
                .findAllAsync();
    }
}