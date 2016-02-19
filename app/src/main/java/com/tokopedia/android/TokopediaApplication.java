package com.tokopedia.android;

import android.app.Application;
import android.content.Context;

import com.tokopedia.android.injection.component.ApplicationComponent;
import com.tokopedia.android.injection.component.DaggerApplicationComponent;
import com.tokopedia.android.injection.component.ProductComponent;
import com.tokopedia.android.injection.component.UserComponent;
import com.tokopedia.android.injection.module.ApplicationModule;
import com.tokopedia.android.injection.module.ProductModule;
import com.tokopedia.android.injection.module.UserModule;
import com.tokopedia.android.service.User;

import timber.log.Timber;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
public class TokopediaApplication extends Application {

    private ApplicationComponent mApplicationComponent;
    //private UserComponent mUserComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) Timber.plant(new Timber.DebugTree());

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        //createUserComponent(new User());
    }

    public static TokopediaApplication get(Context context) {
        return (TokopediaApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    /**
     * Place your component here
     */
    /*public UserComponent createUserComponent(User user) {
        mUserComponent = mApplicationComponent.plus(new UserModule(user));
        return mUserComponent;
    }

    public UserComponent getUserComponent() {
        return mUserComponent;
    }*/
}

