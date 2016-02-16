package com.tokopedia.android;

import android.app.Application;
import android.content.Context;

import com.tokopedia.android.injection.component.ApplicationComponent;
import com.tokopedia.android.injection.component.DaggerApplicationComponent;
import com.tokopedia.android.injection.module.ApplicationModule;

import timber.log.Timber;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
public class TokopediaApplication extends Application {

    ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) Timber.plant(new Timber.DebugTree());

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static TokopediaApplication get(Context context) {
        return (TokopediaApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
