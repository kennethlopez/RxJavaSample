package com.rxjavasample.injection.component;


import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.rxjavasample.data.SyncService;
import com.rxjavasample.data.manger.SyncManager;
import com.rxjavasample.data.manger.UserDataManager;
import com.rxjavasample.injection.module.AppModule;
import com.rxjavasample.util.RxBus;
import com.rxjavasample.view.activity.home.HomePresenterImpl;
import com.rxjavasample.view.activity.user.UserPresenterImpl;
import com.rxjavasample.view.activity.userlist.UserListPresenterImpl;
import com.rxjavasample.view.fragment.about.AboutPresenterImpl;
import com.rxjavasample.view.viewholder.DrawerHeaderViewHolder;

import javax.inject.Singleton;

import dagger.Component;
import io.realm.Realm;
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

    RxBus rxBus();

    UserDataManager userDataManager();

    void inject(HomePresenterImpl homePresenter);

    void inject(UserListPresenterImpl userListPresenter);

    void inject(UserPresenterImpl userPresenter);

    void inject(DrawerHeaderViewHolder viewHolder);

    void inject(AboutPresenterImpl aboutPresenter);

    void inject(SyncManager syncManager);

    void inject(SyncService syncService);
}