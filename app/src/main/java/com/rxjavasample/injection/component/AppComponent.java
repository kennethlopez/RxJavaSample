package com.rxjavasample.injection.component;


import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.rxjavasample.data.SyncService;
import com.rxjavasample.data.manger.SyncManager;
import com.rxjavasample.data.manger.UserDataManager;
import com.rxjavasample.data.remote.ApiService;
import com.rxjavasample.injection.module.AppModule;
import com.rxjavasample.util.RxBus;
import com.rxjavasample.view.activity.home.HomePresenter;
import com.rxjavasample.view.activity.user.UserPresenter;
import com.rxjavasample.view.activity.userlist.UserListPresenter;
import com.rxjavasample.view.fragment.about.AboutPresenter;
import com.rxjavasample.view.viewholder.DrawerHeaderViewHolder;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    Context context();

    SharedPreferences sharedPreferences();

    Gson gson();

    HttpLoggingInterceptor httpLoggingInterceptor();

    Cache cache();

    OkHttpClient okHttpClient();

    Retrofit retrofit();

    ApiService apiService();

    RxBus rxBus();

    UserDataManager userDataManager();

    void inject(HomePresenter homePresenter);

    void inject(UserListPresenter userListPresenter);

    void inject(UserPresenter userPresenter);

    void inject(DrawerHeaderViewHolder viewHolder);

    void inject(AboutPresenter aboutPresenter);

    void inject(SyncManager syncManager);

    void inject(SyncService syncService);
}