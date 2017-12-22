package com.rxjavasample.data;


import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.rxjavasample.base.App;
import com.rxjavasample.data.manger.SyncManager;
import com.rxjavasample.data.model.User;
import com.rxjavasample.injection.component.AppComponent;
import com.rxjavasample.util.AndroidComponentUtil;
import com.rxjavasample.util.NetworkUtil;
import com.rxjavasample.util.RxBus;


import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.realm.Realm;

public class SyncService extends Service {
    @Inject
    transient RxBus mBus;

    private static final String TAG = "SyncService";

    private SyncManager mSyncManager;
    private CompositeDisposable mDisposables = new CompositeDisposable();
    private Realm mRealm;
    private int mSyncedUsersCount;
    private int mUsersCount;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, SyncService.class);
    }

    @SuppressWarnings("unused")
    public static boolean isRunning(Context context) {
        return AndroidComponentUtil.isServiceRunning(context, SyncService.class);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        AppComponent appComponent = App.get(this).getAppComponent();
        appComponent.inject(this);

        mRealm = Realm.getDefaultInstance();
        mSyncManager = new SyncManager(appComponent, mRealm);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "Starting Sync");

        if (!NetworkUtil.hasNetwork(this)) {
            Log.i(TAG, "Sync canceled connection not available");
            AndroidComponentUtil.toggleComponent(this, SyncOnConnectionAvailable.class, true);
            stopSelf(startId);
            return START_NOT_STICKY;
        }

        syncUser(startId);
        return START_NOT_STICKY;
    }

    public void syncUser(int startId) {
        mSyncedUsersCount = 0;
        mUsersCount = mSyncManager.getUsersCount();

        mDisposables.add(mSyncManager.syncUsers()
                .subscribe(user -> onNext(user, startId), throwable -> onError(throwable, startId)));
    }

    private void onNext(User user, int startId) {
        Log.i(TAG, "Synced " + user.getLogin());
        onComplete(startId);
    }

    private void onError(Throwable throwable, int startId) {
        Log.i(TAG, "Error syncing.");
        throwable.printStackTrace();
        stopSelf(startId);
    }

    /**
     * needs to be invoked inside onNext().
     * we resorted to manually counting the emitted values because for some reason the onComplete() is not invoked
     * after all the values has been emitted.
     * */
    private void onComplete(int startId) {
        mSyncedUsersCount++;
        if (mSyncedUsersCount == mUsersCount) {
            Log.i(TAG, "Synced successfully!");

            // post a sample event to try RxBus
            mBus.post("Synced all users successfully!");

            stopSelf(startId);
        }
    }

    @Override
    public void onDestroy() {
        mRealm.close();
        mDisposables.clear();

        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static class SyncOnConnectionAvailable extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null && action.equals(ConnectivityManager.CONNECTIVITY_ACTION)
                    && NetworkUtil.hasNetwork(context)) {
                Log.i(TAG, "Connection is now available, triggering sync...");
                AndroidComponentUtil.toggleComponent(context, this.getClass(), false);
                context.startService(getStartIntent(context));
            }
        }
    }
}