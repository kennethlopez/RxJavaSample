package com.rxjavasample.test.common.injection.module;


import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.rxjavasample.data.manger.UserDataManager;
import com.rxjavasample.data.remote.ApiService;
import com.rxjavasample.util.RxBus;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

import static org.mockito.Mockito.mock;

/**
 * Provides application-level dependencies for an app running on a testing environment
 * This allows injecting mocks if necessary.
 */
@Module
public class AppTestModule {

    private final Application mApplication;

    public AppTestModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return mApplication.getApplicationContext();
    }

    /************* MOCKS *************/

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(@SuppressWarnings("unused") Context context) {
        return mock(SharedPreferences.class);
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return mock(Gson.class);
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        return mock(HttpLoggingInterceptor.class);
    }

    @Provides
    @Singleton
    Cache provideCache() {
        return mock(Cache.class);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return mock(OkHttpClient.class);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return mock(Retrofit.class);
    }

    @Provides
    @Singleton
    ApiService provideApiService() {
        return mock(ApiService.class);
    }

    @Provides
    @Singleton
    RxBus provideRxBus() {
        return mock(RxBus.class);
    }


    @Provides
    @Singleton
    UserDataManager provideUserDataManager() {
        return mock(UserDataManager.class);
    }
}
