package com.rxjavasample.base;


import com.rxjavasample.data.manger.RealmManager;


import javax.annotation.Nonnull;

import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class BaseDb<T extends RealmObject> {

    public void updateOrSave(T data) {
        try (Realm realm = Realm.getDefaultInstance() ) {
            realm.executeTransaction(realmCopy -> realmCopy.copyToRealmOrUpdate(data));
        }
    }

    public int count(Class<T> clazz) {
        try (Realm realm = Realm.getDefaultInstance()) {
            return realm.where(clazz).findAll().size();
        }
    }

    public RealmResults<T> getAllAsRealmResultsAsync(Class<T> clazz, @Nonnull Realm realm) {
        return realm.where(clazz).findAllAsync();
    }

    /**
     * Invoke the methods below on UI thread only, because the realm instance on {@link RealmManager}
     * is created in the UI thread
     * */

    public OrderedRealmCollection<T> getAllAsOrderedRealmCollectionAsync(Class<T> clazz) {
        return RealmManager.getRealm()
                .where(clazz)
                .findAllAsync();
    }

    public RealmResults<T> getAllAsRealmResultsAsync(Class<T> clazz) {
        return getAllAsRealmResultsAsync(clazz, RealmManager.getRealm());
    }
}