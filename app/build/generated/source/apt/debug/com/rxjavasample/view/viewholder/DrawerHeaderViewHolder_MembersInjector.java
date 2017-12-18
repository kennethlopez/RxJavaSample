package com.rxjavasample.view.viewholder;

import android.content.Context;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DrawerHeaderViewHolder_MembersInjector
    implements MembersInjector<DrawerHeaderViewHolder> {
  private final Provider<Context> mContextProvider;

  public DrawerHeaderViewHolder_MembersInjector(Provider<Context> mContextProvider) {
    assert mContextProvider != null;
    this.mContextProvider = mContextProvider;
  }

  public static MembersInjector<DrawerHeaderViewHolder> create(Provider<Context> mContextProvider) {
    return new DrawerHeaderViewHolder_MembersInjector(mContextProvider);
  }

  @Override
  public void injectMembers(DrawerHeaderViewHolder instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mContext = mContextProvider.get();
  }

  public static void injectMContext(
      DrawerHeaderViewHolder instance, Provider<Context> mContextProvider) {
    instance.mContext = mContextProvider.get();
  }
}
