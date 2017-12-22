package com.rxjavasample.base;


import com.rxjavasample.data.remote.ApiService;

import javax.annotation.Nonnull;

import io.realm.Realm;

public abstract class BaseDataManager<T extends BaseDb> {
    private ApiService mApi;
    private T mDb;

    public BaseDataManager(ApiService apiService, T db) {
        mDb = db;
        mApi = apiService;
    }

    /**
     * invoke this method when you want to execute queries outside UI thread
     * */
    public void setRealm(@Nonnull final Realm realm) {
        mDb.setRealm(realm);
    }

    public T getDb() {
        return mDb;
    }

    public void setApi(ApiService api) {
        mApi = api;
    }

    public ApiService getApiService() {
        return mApi;
    }
}