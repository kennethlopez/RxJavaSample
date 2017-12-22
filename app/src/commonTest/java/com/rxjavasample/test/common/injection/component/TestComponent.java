package com.rxjavasample.test.common.injection.component;


import com.rxjavasample.injection.component.AppComponent;
import com.rxjavasample.test.common.injection.module.AppTestModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppTestModule.class)
public interface TestComponent extends AppComponent {
}