package com.pashkobohdan.allcontentinone;

import android.app.Application;

import com.pashkobohdan.allcontentinone.di.ApplicationComponent;
import com.pashkobohdan.allcontentinone.di.DaggerApplicationComponent;
import com.pashkobohdan.allcontentinone.di.modules.ApplicationModule;

public class MyApplication extends Application {
    private ApplicationComponent component;
    public static MyApplication INSTANCE;


    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        //TODO maybe run first getApplicationComponent() here
    }

    @Override
    public void onTerminate() {
//        OpenHelperManager.releaseHelper();// instead of releaseHelper // TODO check for what it was here
        super.onTerminate();
    }

    public ApplicationComponent getApplicationComponent() {
        if (component == null) {
            component = DaggerApplicationComponent
                    .builder()
                    .applicationModule(new ApplicationModule(this))
//                    .databaseModule(new DatabaseModule(this))
                    .build();
        }
        return component;
    }
}
