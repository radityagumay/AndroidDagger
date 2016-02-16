package com.tokopedia.android.injection.module;

import android.app.Application;

import com.squareup.otto.Bus;
import com.tokopedia.android.injection.data.DataManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by raditya.gumay on 16/02/2016.
 * Provide application-level dependencies.
 * Mainly singleton object that can be injected from
 * anywhere in the app.
 */
@Module
public class ApplicationModule {
    protected final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    DataManager provideDataManager() {
        return new DataManager(mApplication);
    }

    @Provides
    @Singleton
    Bus provideEventBus() {
        return new Bus();
    }

}
