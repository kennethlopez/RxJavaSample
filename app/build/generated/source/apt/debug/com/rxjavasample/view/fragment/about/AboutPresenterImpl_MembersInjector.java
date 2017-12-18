package com.rxjavasample.view.fragment.about;

import com.rxjavasample.data.manger.UserDataManager;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AboutPresenterImpl_MembersInjector
    implements MembersInjector<AboutPresenterImpl> {
  private final Provider<UserDataManager> mUserDataManagerProvider;

  public AboutPresenterImpl_MembersInjector(Provider<UserDataManager> mUserDataManagerProvider) {
    assert mUserDataManagerProvider != null;
    this.mUserDataManagerProvider = mUserDataManagerProvider;
  }

  public static MembersInjector<AboutPresenterImpl> create(
      Provider<UserDataManager> mUserDataManagerProvider) {
    return new AboutPresenterImpl_MembersInjector(mUserDataManagerProvider);
  }

  @Override
  public void injectMembers(AboutPresenterImpl instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mUserDataManager = mUserDataManagerProvider.get();
  }

  public static void injectMUserDataManager(
      AboutPresenterImpl instance, Provider<UserDataManager> mUserDataManagerProvider) {
    instance.mUserDataManager = mUserDataManagerProvider.get();
  }
}
