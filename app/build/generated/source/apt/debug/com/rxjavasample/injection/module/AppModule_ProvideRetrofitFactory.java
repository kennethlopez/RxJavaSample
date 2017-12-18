package com.rxjavasample.injection.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvideRetrofitFactory implements Factory<Retrofit> {
  private final AppModule module;

  public AppModule_ProvideRetrofitFactory(AppModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Retrofit get() {
    return Preconditions.checkNotNull(
        module.provideRetrofit(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Retrofit> create(AppModule module) {
    return new AppModule_ProvideRetrofitFactory(module);
  }

  /** Proxies {@link AppModule#provideRetrofit()}. */
  public static Retrofit proxyProvideRetrofit(AppModule instance) {
    return instance.provideRetrofit();
  }
}
