package com.pashkobohdan.allcontentinone.di.modules;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.pashkobohdan.allcontentinone.presentation.ui.utils.EmptyActivityLifecycleCallbacks;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private Context appContext;

    public ApplicationModule(Application application) {
        application.registerActivityLifecycleCallbacks(new EmptyActivityLifecycleCallbacks() {
            @Override
            public void onActivityStarted(Activity activity) {
                appContext = activity;
            }
        });
    }

    @Provides
    Context provideContext() {
        return appContext;
    }
}
