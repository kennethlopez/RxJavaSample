package com.rxjavasample.view.fragment.about;


import com.rxjavasample.base.BasePresenter;
import com.rxjavasample.injection.component.AppComponent;

public abstract class AboutPresenter extends BasePresenter<AboutView> {
    public AboutPresenter(AppComponent appComponent, AboutView view) {
        super(appComponent, view);
    }
}
