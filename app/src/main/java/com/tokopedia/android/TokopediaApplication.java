package com.tokopedia.android;

import android.app.Application;
import android.content.Context;

import com.tokopedia.android.database.DatabaseRealm;
import com.tokopedia.android.injection.component.ApplicationComponent;
import com.tokopedia.android.injection.component.DaggerApplicationComponent;
import com.tokopedia.android.injection.module.ApplicationModule;
import com.tokopedia.android.injection.module.RepositoryModule;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
public class TokopediaApplication extends Application {

    @Inject
    DatabaseRealm databaseRealm;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());

            /**
             * You also can install LeakCanary
             */
        }
        initComponentDepedencies();
        setupRealmDatabase();
    }

    private void setupRealmDatabase() {
        databaseRealm.setup();
    }

    private void initComponentDepedencies() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .repositoryModule(new RepositoryModule())
                .build();
    }

    public static TokopediaApplication get(Context context) {
        return (TokopediaApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }
}

