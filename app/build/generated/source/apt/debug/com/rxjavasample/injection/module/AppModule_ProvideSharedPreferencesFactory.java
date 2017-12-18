package com.rxjavasample.injection.module;

import android.content.Context;
import android.content.SharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvideSharedPreferencesFactory implements Factory<SharedPreferences> {
  private final AppModule module;

  private final Provider<Context> contextProvider;

  public AppModule_ProvideSharedPreferencesFactory(
      AppModule module, Provider<Context> contextProvider) {
    assert module != null;
    this.module = module;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public SharedPreferences get() {
    return Preconditions.checkNotNull(
        module.provideSharedPreferences(contextProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<SharedPreferences> create(
      AppModule module, Provider<Context> contextProvider) {
    return new AppModule_ProvideSharedPreferencesFactory(module, contextProvider);
  }

  /** Proxies {@link AppModule#provideSharedPreferences(Context)}. */
  public static SharedPreferences proxyProvideSharedPreferences(
      AppModule instance, Context context) {
    return instance.provideSharedPreferences(context);
  }
}
