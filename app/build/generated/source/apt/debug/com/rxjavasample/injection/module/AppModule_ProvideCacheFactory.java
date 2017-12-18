package com.rxjavasample.injection.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import okhttp3.Cache;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvideCacheFactory implements Factory<Cache> {
  private final AppModule module;

  public AppModule_ProvideCacheFactory(AppModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Cache get() {
    return Preconditions.checkNotNull(
        module.provideCache(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Cache> create(AppModule module) {
    return new AppModule_ProvideCacheFactory(module);
  }

  /** Proxies {@link AppModule#provideCache()}. */
  public static Cache proxyProvideCache(AppModule instance) {
    return instance.provideCache();
  }
}
