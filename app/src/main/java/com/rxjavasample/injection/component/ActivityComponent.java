package com.rxjavasample.injection.component;

import com.rxjavasample.injection.scope.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class)
public interface ActivityComponent extends AppComponent {
}
