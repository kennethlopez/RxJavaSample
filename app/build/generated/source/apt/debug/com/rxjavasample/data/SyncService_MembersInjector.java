package com.rxjavasample.data;

import com.rxjavasample.util.RxBus;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SyncService_MembersInjector implements MembersInjector<SyncService> {
  private final Provider<RxBus> mBusProvider;

  public SyncService_MembersInjector(Provider<RxBus> mBusProvider) {
    assert mBusProvider != null;
    this.mBusProvider = mBusProvider;
  }

  public static MembersInjector<SyncService> create(Provider<RxBus> mBusProvider) {
    return new SyncService_MembersInjector(mBusProvider);
  }

  @Override
  public void injectMembers(SyncService instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mBus = mBusProvider.get();
  }

  public static void injectMBus(SyncService instance, Provider<RxBus> mBusProvider) {
    instance.mBus = mBusProvider.get();
  }
}
