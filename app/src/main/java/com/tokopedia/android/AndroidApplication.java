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
public class AndroidApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());

            /**
             * You also can install LeakCanary
             */
        }
        initComponentDepedencies();
    }

    private void initComponentDepedencies(){
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static AndroidApplication get(Context context) {
        return (AndroidApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }
}

