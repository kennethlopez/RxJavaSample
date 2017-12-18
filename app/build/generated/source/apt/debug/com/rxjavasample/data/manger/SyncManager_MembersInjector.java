package com.rxjavasample.data.manger;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SyncManager_MembersInjector implements MembersInjector<SyncManager> {
  private final Provider<UserDataManager> mUserDataManagerProvider;

  public SyncManager_MembersInjector(Provider<UserDataManager> mUserDataManagerProvider) {
    assert mUserDataManagerProvider != null;
    this.mUserDataManagerProvider = mUserDataManagerProvider;
  }

  public static MembersInjector<SyncManager> create(
      Provider<UserDataManager> mUserDataManagerProvider) {
    return new SyncManager_MembersInjector(mUserDataManagerProvider);
  }

  @Override
  public void injectMembers(SyncManager instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mUserDataManager = mUserDataManagerProvider.get();
  }

  public static void injectMUserDataManager(
      SyncManager instance, Provider<UserDataManager> mUserDataManagerProvider) {
    instance.mUserDataManager = mUserDataManagerProvider.get();
  }
}
