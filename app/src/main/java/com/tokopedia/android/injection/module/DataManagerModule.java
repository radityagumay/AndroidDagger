package com.tokopedia.android.injection.module;

import android.content.Context;

import com.tokopedia.android.injection.PerDataManager;
import com.tokopedia.android.network.RestService;
import com.tokopedia.android.network.RetrofitHelper;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
@Module
public class DataManagerModule {

    private final Context mContext;

    public DataManagerModule(Context context) {
        mContext = context;
    }

    @Provides
    @PerDataManager
    RestService provideAndroidBoilerplateService() {
        return new RetrofitHelper().newAndroidBoilerplateService();
    }

    @Provides
    @PerDataManager
    Scheduler provideSubscribeScheduler() {
        return Schedulers.io();
    }
}
