package com.rxjavasample.base;


import android.app.Application;
import android.content.Context;

import com.rxjavasample.data.manger.RealmManager;
import com.rxjavasample.injection.component.AppComponent;
import com.rxjavasample.injection.component.DaggerAppComponent;
import com.rxjavasample.injection.module.AppModule;
import com.squareup.leakcanary.LeakCanary;

import io.realm.Realm;

public class App extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmManager.initializeRealmConfig();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
