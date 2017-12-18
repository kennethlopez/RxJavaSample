package com.rxjavasample.injection.module;

import com.rxjavasample.util.RxBus;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvideRxBusFactory implements Factory<RxBus> {
  private final AppModule module;

  public AppModule_ProvideRxBusFactory(AppModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public RxBus get() {
    return Preconditions.checkNotNull(
        module.provideRxBus(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<RxBus> create(AppModule module) {
    return new AppModule_ProvideRxBusFactory(module);
  }

  /** Proxies {@link AppModule#provideRxBus()}. */
  public static RxBus proxyProvideRxBus(AppModule instance) {
    return instance.provideRxBus();
  }
}
