package com.rxjavasample.view.activity.user;

import com.rxjavasample.data.manger.UserDataManager;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UserPresenterImpl_MembersInjector implements MembersInjector<UserPresenterImpl> {
  private final Provider<UserDataManager> mUserDataManagerProvider;

  public UserPresenterImpl_MembersInjector(Provider<UserDataManager> mUserDataManagerProvider) {
    assert mUserDataManagerProvider != null;
    this.mUserDataManagerProvider = mUserDataManagerProvider;
  }

  public static MembersInjector<UserPresenterImpl> create(
      Provider<UserDataManager> mUserDataManagerProvider) {
    return new UserPresenterImpl_MembersInjector(mUserDataManagerProvider);
  }

  @Override
  public void injectMembers(UserPresenterImpl instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mUserDataManager = mUserDataManagerProvider.get();
  }

  public static void injectMUserDataManager(
      UserPresenterImpl instance, Provider<UserDataManager> mUserDataManagerProvider) {
    instance.mUserDataManager = mUserDataManagerProvider.get();
  }
}
