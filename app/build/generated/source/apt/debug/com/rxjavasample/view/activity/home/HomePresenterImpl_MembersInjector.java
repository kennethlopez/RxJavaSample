package com.rxjavasample.view.activity.home;

import com.rxjavasample.data.manger.UserDataManager;
import com.rxjavasample.util.RxBus;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HomePresenterImpl_MembersInjector implements MembersInjector<HomePresenterImpl> {
  private final Provider<UserDataManager> mUserDataManagerProvider;

  private final Provider<RxBus> mBusProvider;

  public HomePresenterImpl_MembersInjector(
      Provider<UserDataManager> mUserDataManagerProvider, Provider<RxBus> mBusProvider) {
    assert mUserDataManagerProvider != null;
    this.mUserDataManagerProvider = mUserDataManagerProvider;
    assert mBusProvider != null;
    this.mBusProvider = mBusProvider;
  }

  public static MembersInjector<HomePresenterImpl> create(
      Provider<UserDataManager> mUserDataManagerProvider, Provider<RxBus> mBusProvider) {
    return new HomePresenterImpl_MembersInjector(mUserDataManagerProvider, mBusProvider);
  }

  @Override
  public void injectMembers(HomePresenterImpl instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mUserDataManager = mUserDataManagerProvider.get();
    instance.mBus = mBusProvider.get();
  }

  public static void injectMUserDataManager(
      HomePresenterImpl instance, Provider<UserDataManager> mUserDataManagerProvider) {
    instance.mUserDataManager = mUserDataManagerProvider.get();
  }

  public static void injectMBus(HomePresenterImpl instance, Provider<RxBus> mBusProvider) {
    instance.mBus = mBusProvider.get();
  }
}
