package com.rxjavasample.injection.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import okhttp3.logging.HttpLoggingInterceptor;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvideHttpLoggingInterceptorFactory
    implements Factory<HttpLoggingInterceptor> {
  private final AppModule module;

  public AppModule_ProvideHttpLoggingInterceptorFactory(AppModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public HttpLoggingInterceptor get() {
    return Preconditions.checkNotNull(
        module.provideHttpLoggingInterceptor(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<HttpLoggingInterceptor> create(AppModule module) {
    return new AppModule_ProvideHttpLoggingInterceptorFactory(module);
  }

  /** Proxies {@link AppModule#provideHttpLoggingInterceptor()}. */
  public static HttpLoggingInterceptor proxyProvideHttpLoggingInterceptor(AppModule instance) {
    return instance.provideHttpLoggingInterceptor();
  }
}
