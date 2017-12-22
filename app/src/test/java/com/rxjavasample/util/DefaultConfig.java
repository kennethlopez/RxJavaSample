package com.rxjavasample.util;


import io.realm.RealmConfiguration;

/**
 * Robolectric default config properties
 */
public class DefaultConfig {
    //The api level that Roboelectric will use to run the unit tests
    public static final int EMULATE_SDK = 19;

    public static RealmConfiguration getRealmConfig() {
        return new RealmConfiguration.Builder()
                .inMemory()
                .name("test-rxjasample.realm")
                .build();
    }
}
