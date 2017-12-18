package com.rxjavasample.view.activity.home;


import com.rxjavasample.base.BasePresenter;
import com.rxjavasample.injection.component.AppComponent;

abstract class HomePresenter extends BasePresenter<HomeView> {
    HomePresenter(AppComponent appComponent, HomeView view) {
        super(appComponent, view);
    }

    protected abstract void onTextChangedUsername(CharSequence charSequence, int start, int before, int count);
}
