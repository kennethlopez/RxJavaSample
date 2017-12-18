package com.rxjavasample.injection.component;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.rxjavasample.data.SyncService;
import com.rxjavasample.data.SyncService_MembersInjector;
import com.rxjavasample.data.manger.SyncManager;
import com.rxjavasample.data.manger.SyncManager_MembersInjector;
import com.rxjavasample.data.manger.UserDataManager;
import com.rxjavasample.injection.module.AppModule;
import com.rxjavasample.injection.module.AppModule_ProvideCacheFactory;
import com.rxjavasample.injection.module.AppModule_ProvideContextFactory;
import com.rxjavasample.injection.module.AppModule_ProvideGsonFactory;
import com.rxjavasample.injection.module.AppModule_ProvideHttpLoggingInterceptorFactory;
import com.rxjavasample.injection.module.AppModule_ProvideOkHttpClientFactory;
import com.rxjavasample.injection.module.AppModule_ProvideRetrofitFactory;
import com.rxjavasample.injection.module.AppModule_ProvideRxBusFactory;
import com.rxjavasample.injection.module.AppModule_ProvideSharedPreferencesFactory;
import com.rxjavasample.injection.module.AppModule_ProvideUserDataManagerFactory;
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
import dagger.internal.DoubleCheck;
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
public final class DaggerAppComponent implements AppComponent {
  private Provider<Context> provideContextProvider;

  private Provider<SharedPreferences> provideSharedPreferencesProvider;

  private Provider<Gson> provideGsonProvider;

  private Provider<HttpLoggingInterceptor> provideHttpLoggingInterceptorProvider;

  private Provider<Cache> provideCacheProvider;

  private Provider<OkHttpClient> provideOkHttpClientProvider;

  private Provider<Retrofit> provideRetrofitProvider;

  private Provider<RxBus> provideRxBusProvider;

  private Provider<UserDataManager> provideUserDataManagerProvider;

  private MembersInjector<HomePresenterImpl> homePresenterImplMembersInjector;

  private MembersInjector<UserListPresenterImpl> userListPresenterImplMembersInjector;

  private MembersInjector<UserPresenterImpl> userPresenterImplMembersInjector;

  private MembersInjector<DrawerHeaderViewHolder> drawerHeaderViewHolderMembersInjector;

  private MembersInjector<AboutPresenterImpl> aboutPresenterImplMembersInjector;

  private MembersInjector<SyncManager> syncManagerMembersInjector;

  private MembersInjector<SyncService> syncServiceMembersInjector;

  private DaggerAppComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideContextProvider =
        DoubleCheck.provider(AppModule_ProvideContextFactory.create(builder.appModule));

    this.provideSharedPreferencesProvider =
        DoubleCheck.provider(
            AppModule_ProvideSharedPreferencesFactory.create(
                builder.appModule, provideContextProvider));

    this.provideGsonProvider =
        DoubleCheck.provider(AppModule_ProvideGsonFactory.create(builder.appModule));

    this.provideHttpLoggingInterceptorProvider =
        DoubleCheck.provider(
            AppModule_ProvideHttpLoggingInterceptorFactory.create(builder.appModule));

    this.provideCacheProvider =
        DoubleCheck.provider(AppModule_ProvideCacheFactory.create(builder.appModule));

    this.provideOkHttpClientProvider =
        DoubleCheck.provider(AppModule_ProvideOkHttpClientFactory.create(builder.appModule));

    this.provideRetrofitProvider =
        DoubleCheck.provider(AppModule_ProvideRetrofitFactory.create(builder.appModule));

    this.provideRxBusProvider =
        DoubleCheck.provider(AppModule_ProvideRxBusFactory.create(builder.appModule));

    this.provideUserDataManagerProvider =
        AppModule_ProvideUserDataManagerFactory.create(builder.appModule);

    this.homePresenterImplMembersInjector =
        HomePresenterImpl_MembersInjector.create(
            provideUserDataManagerProvider, provideRxBusProvider);

    this.userListPresenterImplMembersInjector =
        UserListPresenterImpl_MembersInjector.create(provideUserDataManagerProvider);

    this.userPresenterImplMembersInjector =
        UserPresenterImpl_MembersInjector.create(provideUserDataManagerProvider);

    this.drawerHeaderViewHolderMembersInjector =
        DrawerHeaderViewHolder_MembersInjector.create(provideContextProvider);

    this.aboutPresenterImplMembersInjector =
        AboutPresenterImpl_MembersInjector.create(provideUserDataManagerProvider);

    this.syncManagerMembersInjector =
        SyncManager_MembersInjector.create(provideUserDataManagerProvider);

    this.syncServiceMembersInjector = SyncService_MembersInjector.create(provideRxBusProvider);
  }

  @Override
  public Context context() {
    return provideContextProvider.get();
  }

  @Override
  public SharedPreferences sharedPreferences() {
    return provideSharedPreferencesProvider.get();
  }

  @Override
  public Gson gson() {
    return provideGsonProvider.get();
  }

  @Override
  public HttpLoggingInterceptor httpLoggingInterceptor() {
    return provideHttpLoggingInterceptorProvider.get();
  }

  @Override
  public Cache cache() {
    return provideCacheProvider.get();
  }

  @Override
  public OkHttpClient okHttpClient() {
    return provideOkHttpClientProvider.get();
  }

  @Override
  public Retrofit retrofit() {
    return provideRetrofitProvider.get();
  }

  @Override
  public RxBus rxBus() {
    return provideRxBusProvider.get();
  }

  @Override
  public UserDataManager userDataManager() {
    return provideUserDataManagerProvider.get();
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
    private AppModule appModule;

    private Builder() {}

    public AppComponent build() {
      if (appModule == null) {
        throw new IllegalStateException(AppModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerAppComponent(this);
    }

    public Builder appModule(AppModule appModule) {
      this.appModule = Preconditions.checkNotNull(appModule);
      return this;
    }
  }
}
