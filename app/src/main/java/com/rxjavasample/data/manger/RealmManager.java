package com.rxjavasample.data.manger;


import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RealmManager {
    private static Realm realm;

    private static RealmConfiguration realmConfiguration;

    public static void initializeRealmConfig() {
        if(realmConfiguration == null) {
            setRealmConfiguration(new RealmConfiguration.Builder()
                    .name("rxjavasample.realm")
                    .schemaVersion(1)
                    .deleteRealmIfMigrationNeeded()
                    .build());
        }
    }

    public static void setRealmConfiguration(RealmConfiguration realmConfiguration) {
        RealmManager.realmConfiguration = realmConfiguration;
        Realm.setDefaultConfiguration(realmConfiguration);
    }

    private static int activityCount = 0;

    public static Realm getRealm() {
        return realm;
    }

    public static void incrementCount() {
        if(activityCount == 0) {
            if(realm != null) {
                if(!realm.isClosed()) {
                    realm.close();
                    realm = null;
                }
            }
            realm = Realm.getDefaultInstance();
        }
        activityCount++;
    }

    public static void decrementCount() {
        activityCount--;
        if(activityCount <= 0) {
            activityCount = 0;
            realm.close();
            Realm.compactRealm(realmConfiguration);
            realm = null;
        }
    }
}