package com.rxjavasample.injection.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.rxjavasample.BuildConfig;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rxjavasample.base.App;
import com.rxjavasample.constants.AppConstants;
import com.rxjavasample.data.local.UserDb;
import com.rxjavasample.data.manger.UserDataManager;
import com.rxjavasample.util.NetworkUtil;
import com.rxjavasample.util.RxBus;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmObject;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static okhttp3.logging.HttpLoggingInterceptor.Level.HEADERS;
import static okhttp3.logging.HttpLoggingInterceptor.Level.NONE;

@Module
public class AppModule {
    private static final String TAG = "AppModule";
    private final App mApp;

    public AppModule(App mApp) {
        this.mApp = mApp;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return mApp.getApplicationContext();
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Context context) {
        return context.getSharedPreferences(AppConstants.SHARED_PREFERENCES, Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    Gson provideGson() {
        // http://stackoverflow.com/a/28361096/5134063
        return new GsonBuilder()
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        return f.getDeclaringClass().equals(RealmObject.class);
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                })
                .create();
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(message -> Log.d(TAG, message));
        interceptor.setLevel(BuildConfig.DEBUG ? HEADERS : NONE);
        return interceptor;
    }

    @Provides
    @Singleton
    Cache provideCache() {
        Cache cache = null;
        try {
            cache = new Cache(new File(mApp.getCacheDir(), "http-cache"), 1024 * 1024 * 10); // 10mb
        } catch (Exception e) {
            Log.e(TAG, "Could not create cache!");
        }
        return cache;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(chain -> {  // cache
                    Response response = chain.proceed(chain.request());
                    // re-write response header to force use of cache
                    CacheControl cacheControl = new CacheControl.Builder()
                            .maxAge(2, TimeUnit.MINUTES)
                            .build();
                    return response.newBuilder()
                            .header("Cache-Control", cacheControl.toString())
                            .build();
                })
                .addInterceptor(chain -> {  // offline cache
                    Request request = chain.request();
                    if (!NetworkUtil.hasNetwork(provideContext())) {
                        CacheControl cacheControl = new CacheControl.Builder()
                                .maxStale(7, TimeUnit.DAYS)
                                .build();
                        request = request.newBuilder()
                                .cacheControl(cacheControl)
                                .build();
                    }
                    return chain.proceed(request);
                })
                .addInterceptor(chain -> {  // User-Agent changes
                    Request original = chain.request();
                    Request request = original.newBuilder()
                            .addHeader("User-Agent", System.getProperty("http.agent"))
                            .build();
                    return chain.proceed(request);
                })
                .addNetworkInterceptor(provideHttpLoggingInterceptor())
                .cache(provideCache())
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
    }

    // https://square.github.io/okhttp/2.x/okhttp/com/squareup/okhttp/OkHttpClient.html
    // http://stackoverflow.com/a/37156033
    // https://goo.gl/KGMcsr
    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .client(provideOkHttpClient())
                .baseUrl(AppConstants.API_HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    RxBus provideRxBus() {
        return new RxBus();
    }

    @Provides
    UserDataManager provideUserDataManager() {
        return new UserDataManager(provideRetrofit(), new UserDb());
    }
}