package com.rxjavasample.base;


import com.rxjavasample.data.remote.ApiService;

import retrofit2.Retrofit;

public class BaseDataManager<T extends BaseDb> {
    private ApiService mApi;
    private T mDb;

    public BaseDataManager(Retrofit retrofit, T db) {
        mDb = db;
        mApi = retrofit.create(ApiService.class);
    }

    public T getDb() {
        return mDb;
    }

    public void setApi(ApiService api) {
        mApi = api;
    }

    protected ApiService getApi() {
        return mApi;
    }
}