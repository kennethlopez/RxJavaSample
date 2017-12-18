package com.rxjavasample.view.activity.userlist;

import com.rxjavasample.data.manger.UserDataManager;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UserListPresenterImpl_MembersInjector
    implements MembersInjector<UserListPresenterImpl> {
  private final Provider<UserDataManager> mUserDataManagerProvider;

  public UserListPresenterImpl_MembersInjector(Provider<UserDataManager> mUserDataManagerProvider) {
    assert mUserDataManagerProvider != null;
    this.mUserDataManagerProvider = mUserDataManagerProvider;
  }

  public static MembersInjector<UserListPresenterImpl> create(
      Provider<UserDataManager> mUserDataManagerProvider) {
    return new UserListPresenterImpl_MembersInjector(mUserDataManagerProvider);
  }

  @Override
  public void injectMembers(UserListPresenterImpl instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mUserDataManager = mUserDataManagerProvider.get();
  }

  public static void injectMUserDataManager(
      UserListPresenterImpl instance, Provider<UserDataManager> mUserDataManagerProvider) {
    instance.mUserDataManager = mUserDataManagerProvider.get();
  }
}
