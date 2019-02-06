package com.gsanthosh.app;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.gsanthosh.app.injections.Components.AppComponent;
import com.gsanthosh.app.injections.Components.DaggerAppComponent;
import com.gsanthosh.app.injections.modules.AppModule;

/**
 * Created by gsanthosh91 on 06-02-2019.
 */

public class MVVMApplication extends Application {

    static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        if (appComponent == null)
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .build();
    }

    public static AppComponent getComponent() {
        return appComponent;
    }
}
