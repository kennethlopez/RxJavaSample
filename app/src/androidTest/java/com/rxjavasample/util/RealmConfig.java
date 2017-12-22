package com.rxjavasample.util;


import io.realm.RealmConfiguration;

public class RealmConfig {
    public static RealmConfiguration getRealmConfig() {
        return new RealmConfiguration.Builder()
                .inMemory()
                .name("test-rxjasample.realm")
                .build();
    }
}
