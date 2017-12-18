package com.rxjavasample.injection.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.realm.Realm;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvideRealmFactory implements Factory<Realm> {
  private final AppModule module;

  public AppModule_ProvideRealmFactory(AppModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Realm get() {
    return Preconditions.checkNotNull(
        module.provideRealm(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Realm> create(AppModule module) {
    return new AppModule_ProvideRealmFactory(module);
  }
}
