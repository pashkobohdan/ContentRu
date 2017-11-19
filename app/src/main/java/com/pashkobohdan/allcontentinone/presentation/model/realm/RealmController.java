package com.pashkobohdan.allcontentinone.presentation.model.realm;

import io.realm.Realm;
import io.realm.RealmResults;


public class RealmController {
    private final Realm realm;

    public RealmController(Realm realm) {
        this.realm = realm;
    }

    public Realm getRealm() {
        return realm;
    }

    public void refresh() {
        realm.refresh();
    }

    public void clearAll() {
        realm.beginTransaction();
        realm.where(SourceDTORealmObject.class).findAll().clear();
        realm.commitTransaction();
    }

    public RealmResults<SourceDTORealmObject> getSourceDTOs() {
        return realm.where(SourceDTORealmObject.class).findAll();
    }

}