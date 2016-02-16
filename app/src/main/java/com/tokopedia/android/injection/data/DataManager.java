package com.tokopedia.android.injection.data;

import android.content.Context;

import com.squareup.otto.Bus;
import com.tokopedia.android.TokopediaApplication;
import com.tokopedia.android.injection.component.DaggerDataManagerComponent;
import com.tokopedia.android.injection.module.DataManagerModule;
import com.tokopedia.android.network.RestService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Scheduler;
import rx.functions.Func1;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
public class DataManager {

    @Inject
    protected RestService mRestService;

    /**
     * You also have to Inject Database, Preference here
     */

    @Inject
    protected Scheduler mSubscribeScheduler;
    @Inject
    protected Bus mEventBus;

    public DataManager(Context context) {
        injectDependencies(context);
    }

    /* This constructor is provided so we can set up a DataManager with mocks from unit test.
     * At the moment this is not possible to do with Dagger because the Gradle APT plugin doesn't
     * work for the unit test variant, plus Dagger 2 doesn't provide a nice way of overriding
     * modules */
    public DataManager(RestService restService,
                       Bus eventBus,
                       Scheduler subscribeScheduler) {
        this.mRestService = restService;
        this.mEventBus = eventBus;
        this.mSubscribeScheduler = subscribeScheduler;
    }

    protected void injectDependencies(Context context) {
        DaggerDataManagerComponent.builder()
                .applicationComponent(TokopediaApplication.get(context).getComponent())
                .dataManagerModule(new DataManagerModule(context))
                .build()
                .inject(this);
    }

    public Scheduler getSubscribeScheduler() {
        return mSubscribeScheduler;
    }

    public Scheduler getScheduler() {
        return mSubscribeScheduler;
    }

    public Observable<Character> getCharacters(int[] ids) {
        List<Integer> characterIds = new ArrayList<>(ids.length);
        for (int id : ids) characterIds.add(id);
        return Observable.from(characterIds).concatMap(new Func1<Integer, Observable<Character>>() {
            @Override
            public Observable<Character> call(Integer integer) {
                return mRestService.getCharacter(integer);
            }
        });
    }
}