package com.rxjavasample.injection.module;

import com.rxjavasample.data.manger.UserDataManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvideUserDataManagerFactory implements Factory<UserDataManager> {
  private final AppModule module;

  public AppModule_ProvideUserDataManagerFactory(AppModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public UserDataManager get() {
    return Preconditions.checkNotNull(
        module.provideUserDataManager(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<UserDataManager> create(AppModule module) {
    return new AppModule_ProvideUserDataManagerFactory(module);
  }

  /** Proxies {@link AppModule#provideUserDataManager()}. */
  public static UserDataManager proxyProvideUserDataManager(AppModule instance) {
    return instance.provideUserDataManager();
  }
}
