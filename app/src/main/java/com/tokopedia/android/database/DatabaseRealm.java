package com.tokopedia.android.database;

import android.content.Context;

import com.google.common.collect.ImmutableList;
import com.tokopedia.android.TokopediaApplication;
import com.tokopedia.android.ui.Callback;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import timber.log.Timber;

/**
 * Created by raditya.gumay on 23/02/2016.
 */
public class DatabaseRealm {

    @Inject
    Context context;

    RealmConfiguration realmConfiguration;

    public DatabaseRealm() {
        TokopediaApplication.get(context).getComponent().inject(this);
    }

    public Realm getRealmInstance() {
        return Realm.getDefaultInstance();
    }

    public void setup() {
        if (realmConfiguration == null) {
            realmConfiguration = new RealmConfiguration.Builder(context).build();
            Realm.setDefaultConfiguration(realmConfiguration);
        } else {
            Timber.e("Database has configure");
        }
    }

    public <T extends RealmObject> T addSync(T model) {
        Realm realm = getRealmInstance();
        realm.beginTransaction();
        realm.copyToRealm(model);
        realm.commitTransaction();
        return model;
    }

    public <T extends RealmObject> List<T> addAllSync(List<T> models) {
        for (int i = 0; i < models.size(); i++) {
            addSync(models.get(i));
        }
        return models;
    }

    public <T extends RealmObject> List<T> findAll(Class<T> clazz) {
        return getRealmInstance().where(clazz).findAll();
    }

    public static class User extends RealmObject {
        public int id;
        public String name;
    }

    private Class<? extends RealmObject> clazaz;

    public <T> void addAsync(final T model,
                             final Class<? extends RealmObject> clazz,
                             final Callback callback) {
        getRealmInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

            }
        }, new Realm.Transaction.Callback() {
            @Override
            public void onSuccess() {
                super.onSuccess();
                if(callback !)
            }

            @Override
            public void onError(Exception e) {
                super.onError(e);
            }
        });
    }

    public <T> void addAllAsync(final T model, final Class<? extends RealmObject> clazz) {
        getRealmInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                User user = realm.createObject(User.class);
                user.id =

            }
        }, new Realm.Transaction.Callback() {
            @Override
            public void onSuccess() {
                super.onSuccess();
            }

            @Override
            public void onError(Exception e) {
                super.onError(e);
            }
        });
    }
}
