package com.pashkobohdan.allcontentinone.di.modules;

import android.app.Application;

import com.pashkobohdan.allcontentinone.presentation.model.realm.RealmController;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

@Module
public class DatabaseModule {
    private Realm realm;
    private RealmController realmController;

    public DatabaseModule(Application application) {
//        realm = Realm.getInstance(application.getApplicationContext());
//        realmController = new RealmController(realm);
    }

    @Provides
    RealmController provideRealmController() {
        return realmController;
    }

}
