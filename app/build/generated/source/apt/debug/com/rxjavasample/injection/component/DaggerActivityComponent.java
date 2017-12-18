package com.rxjavasample.injection.component;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.rxjavasample.data.SyncService;
import com.rxjavasample.data.SyncService_MembersInjector;
import com.rxjavasample.data.manger.SyncManager;
import com.rxjavasample.data.manger.SyncManager_MembersInjector;
import com.rxjavasample.data.manger.UserDataManager;
import com.rxjavasample.util.RxBus;
import com.rxjavasample.view.activity.home.HomePresenterImpl;
import com.rxjavasample.view.activity.home.HomePresenterImpl_MembersInjector;
import com.rxjavasample.view.activity.user.UserPresenterImpl;
import com.rxjavasample.view.activity.user.UserPresenterImpl_MembersInjector;
import com.rxjavasample.view.activity.userlist.UserListPresenterImpl;
import com.rxjavasample.view.activity.userlist.UserListPresenterImpl_MembersInjector;
import com.rxjavasample.view.fragment.about.AboutPresenterImpl;
import com.rxjavasample.view.fragment.about.AboutPresenterImpl_MembersInjector;
import com.rxjavasample.view.viewholder.DrawerHeaderViewHolder;
import com.rxjavasample.view.viewholder.DrawerHeaderViewHolder_MembersInjector;
import dagger.MembersInjector;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerActivityComponent implements ActivityComponent {
  private Provider<Context> contextProvider;

  private Provider<SharedPreferences> sharedPreferencesProvider;

  private Provider<Gson> gsonProvider;

  private Provider<HttpLoggingInterceptor> httpLoggingInterceptorProvider;

  private Provider<Cache> cacheProvider;

  private Provider<OkHttpClient> okHttpClientProvider;

  private Provider<Retrofit> retrofitProvider;

  private Provider<RxBus> rxBusProvider;

  private Provider<UserDataManager> userDataManagerProvider;

  private MembersInjector<HomePresenterImpl> homePresenterImplMembersInjector;

  private MembersInjector<UserListPresenterImpl> userListPresenterImplMembersInjector;

  private MembersInjector<UserPresenterImpl> userPresenterImplMembersInjector;

  private MembersInjector<DrawerHeaderViewHolder> drawerHeaderViewHolderMembersInjector;

  private MembersInjector<AboutPresenterImpl> aboutPresenterImplMembersInjector;

  private MembersInjector<SyncManager> syncManagerMembersInjector;

  private MembersInjector<SyncService> syncServiceMembersInjector;

  private DaggerActivityComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.contextProvider =
        new com_rxjavasample_injection_component_AppComponent_context(builder.appComponent);

    this.sharedPreferencesProvider =
        new com_rxjavasample_injection_component_AppComponent_sharedPreferences(
            builder.appComponent);

    this.gsonProvider =
        new com_rxjavasample_injection_component_AppComponent_gson(builder.appComponent);

    this.httpLoggingInterceptorProvider =
        new com_rxjavasample_injection_component_AppComponent_httpLoggingInterceptor(
            builder.appComponent);

    this.cacheProvider =
        new com_rxjavasample_injection_component_AppComponent_cache(builder.appComponent);

    this.okHttpClientProvider =
        new com_rxjavasample_injection_component_AppComponent_okHttpClient(builder.appComponent);

    this.retrofitProvider =
        new com_rxjavasample_injection_component_AppComponent_retrofit(builder.appComponent);

    this.rxBusProvider =
        new com_rxjavasample_injection_component_AppComponent_rxBus(builder.appComponent);

    this.userDataManagerProvider =
        new com_rxjavasample_injection_component_AppComponent_userDataManager(builder.appComponent);

    this.homePresenterImplMembersInjector =
        HomePresenterImpl_MembersInjector.create(userDataManagerProvider, rxBusProvider);

    this.userListPresenterImplMembersInjector =
        UserListPresenterImpl_MembersInjector.create(userDataManagerProvider);

    this.userPresenterImplMembersInjector =
        UserPresenterImpl_MembersInjector.create(userDataManagerProvider);

    this.drawerHeaderViewHolderMembersInjector =
        DrawerHeaderViewHolder_MembersInjector.create(contextProvider);

    this.aboutPresenterImplMembersInjector =
        AboutPresenterImpl_MembersInjector.create(userDataManagerProvider);

    this.syncManagerMembersInjector = SyncManager_MembersInjector.create(userDataManagerProvider);

    this.syncServiceMembersInjector = SyncService_MembersInjector.create(rxBusProvider);
  }

  @Override
  public Context context() {
    return contextProvider.get();
  }

  @Override
  public SharedPreferences sharedPreferences() {
    return sharedPreferencesProvider.get();
  }

  @Override
  public Gson gson() {
    return gsonProvider.get();
  }

  @Override
  public HttpLoggingInterceptor httpLoggingInterceptor() {
    return httpLoggingInterceptorProvider.get();
  }

  @Override
  public Cache cache() {
    return cacheProvider.get();
  }

  @Override
  public OkHttpClient okHttpClient() {
    return okHttpClientProvider.get();
  }

  @Override
  public Retrofit retrofit() {
    return retrofitProvider.get();
  }

  @Override
  public RxBus rxBus() {
    return rxBusProvider.get();
  }

  @Override
  public UserDataManager userDataManager() {
    return userDataManagerProvider.get();
  }

  @Override
  public void inject(HomePresenterImpl homePresenter) {
    homePresenterImplMembersInjector.injectMembers(homePresenter);
  }

  @Override
  public void inject(UserListPresenterImpl userListPresenter) {
    userListPresenterImplMembersInjector.injectMembers(userListPresenter);
  }

  @Override
  public void inject(UserPresenterImpl userPresenter) {
    userPresenterImplMembersInjector.injectMembers(userPresenter);
  }

  @Override
  public void inject(DrawerHeaderViewHolder viewHolder) {
    drawerHeaderViewHolderMembersInjector.injectMembers(viewHolder);
  }

  @Override
  public void inject(AboutPresenterImpl aboutPresenter) {
    aboutPresenterImplMembersInjector.injectMembers(aboutPresenter);
  }

  @Override
  public void inject(SyncManager syncManager) {
    syncManagerMembersInjector.injectMembers(syncManager);
  }

  @Override
  public void inject(SyncService syncService) {
    syncServiceMembersInjector.injectMembers(syncService);
  }

  public static final class Builder {
    private AppComponent appComponent;

    private Builder() {}

    public ActivityComponent build() {
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerActivityComponent(this);
    }

    public Builder appComponent(AppComponent appComponent) {
      this.appComponent = Preconditions.checkNotNull(appComponent);
      return this;
    }
  }

  private static class com_rxjavasample_injection_component_AppComponent_context
      implements Provider<Context> {
    private final AppComponent appComponent;

    com_rxjavasample_injection_component_AppComponent_context(AppComponent appComponent) {
      this.appComponent = appComponent;
    }

    @Override
    public Context get() {
      return Preconditions.checkNotNull(
          appComponent.context(), "Cannot return null from a non-@Nullable component method");
    }
  }

  private static class com_rxjavasample_injection_component_AppComponent_sharedPreferences
      implements Provider<SharedPreferences> {
    private final AppComponent appComponent;

    com_rxjavasample_injection_component_AppComponent_sharedPreferences(AppComponent appComponent) {
      this.appComponent = appComponent;
    }

    @Override
    public SharedPreferences get() {
      return Preconditions.checkNotNull(
          appComponent.sharedPreferences(),
          "Cannot return null from a non-@Nullable component method");
    }
  }

  private static class com_rxjavasample_injection_component_AppComponent_gson
      implements Provider<Gson> {
    private final AppComponent appComponent;

    com_rxjavasample_injection_component_AppComponent_gson(AppComponent appComponent) {
      this.appComponent = appComponent;
    }

    @Override
    public Gson get() {
      return Preconditions.checkNotNull(
          appComponent.gson(), "Cannot return null from a non-@Nullable component method");
    }
  }

  private static class com_rxjavasample_injection_component_AppComponent_httpLoggingInterceptor
      implements Provider<HttpLoggingInterceptor> {
    private final AppComponent appComponent;

    com_rxjavasample_injection_component_AppComponent_httpLoggingInterceptor(
        AppComponent appComponent) {
      this.appComponent = appComponent;
    }

    @Override
    public HttpLoggingInterceptor get() {
      return Preconditions.checkNotNull(
          appComponent.httpLoggingInterceptor(),
          "Cannot return null from a non-@Nullable component method");
    }
  }

  private static class com_rxjavasample_injection_component_AppComponent_cache
      implements Provider<Cache> {
    private final AppComponent appComponent;

    com_rxjavasample_injection_component_AppComponent_cache(AppComponent appComponent) {
      this.appComponent = appComponent;
    }

    @Override
    public Cache get() {
      return Preconditions.checkNotNull(
          appComponent.cache(), "Cannot return null from a non-@Nullable component method");
    }
  }

  private static class com_rxjavasample_injection_component_AppComponent_okHttpClient
      implements Provider<OkHttpClient> {
    private final AppComponent appComponent;

    com_rxjavasample_injection_component_AppComponent_okHttpClient(AppComponent appComponent) {
      this.appComponent = appComponent;
    }

    @Override
    public OkHttpClient get() {
      return Preconditions.checkNotNull(
          appComponent.okHttpClient(), "Cannot return null from a non-@Nullable component method");
    }
  }

  private static class com_rxjavasample_injection_component_AppComponent_retrofit
      implements Provider<Retrofit> {
    private final AppComponent appComponent;

    com_rxjavasample_injection_component_AppComponent_retrofit(AppComponent appComponent) {
      this.appComponent = appComponent;
    }

    @Override
    public Retrofit get() {
      return Preconditions.checkNotNull(
          appComponent.retrofit(), "Cannot return null from a non-@Nullable component method");
    }
  }

  private static class com_rxjavasample_injection_component_AppComponent_rxBus
      implements Provider<RxBus> {
    private final AppComponent appComponent;

    com_rxjavasample_injection_component_AppComponent_rxBus(AppComponent appComponent) {
      this.appComponent = appComponent;
    }

    @Override
    public RxBus get() {
      return Preconditions.checkNotNull(
          appComponent.rxBus(), "Cannot return null from a non-@Nullable component method");
    }
  }

  private static class com_rxjavasample_injection_component_AppComponent_userDataManager
      implements Provider<UserDataManager> {
    private final AppComponent appComponent;

    com_rxjavasample_injection_component_AppComponent_userDataManager(AppComponent appComponent) {
      this.appComponent = appComponent;
    }

    @Override
    public UserDataManager get() {
      return Preconditions.checkNotNull(
          appComponent.userDataManager(),
          "Cannot return null from a non-@Nullable component method");
    }
  }
}
