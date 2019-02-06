package com.gsanthosh.app.injections.Components;

import com.gsanthosh.app.injections.modules.AppModule;
import com.gsanthosh.app.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by gsanthosh91 on 06-02-2019.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);
}
