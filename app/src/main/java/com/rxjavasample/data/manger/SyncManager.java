package com.rxjavasample.data.manger;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.rxjavasample.constants.AppConstants;
import com.rxjavasample.data.model.User;
import com.rxjavasample.data.remote.ApiService;
import com.rxjavasample.injection.component.AppComponent;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.realm.Realm;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SyncManager {
    @Inject UserDataManager mUserDataManager;

    private final Realm mRealm;

    public SyncManager(AppComponent appComponent, Realm realm) {
        appComponent.inject(this);
        mRealm = realm;
        mUserDataManager.setRealm(mRealm);

        setApiService();
    }

    public Flowable<User> syncUsers() {
        return mUserDataManager.syncUsers();
    }

    public int getUsersCount() {
        return mUserDataManager.getDb().count(User.class);
    }

    private void setApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(provideOkHttpClient())
                .baseUrl(AppConstants.API_HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        mUserDataManager.setApi(retrofit.create(ApiService.class));
    }

    private OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(chain -> {  // User-Agent
                    Request original = chain.request();
                    Request request = original.newBuilder()
                            .addHeader("User-Agent", System.getProperty("http.agent"))
                            .build();
                    return chain.proceed(request);
                })
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
    }
}