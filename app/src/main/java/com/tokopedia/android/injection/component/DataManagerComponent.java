package com.tokopedia.android.injection.component;

import com.tokopedia.android.injection.PerDataManager;

import dagger.Component;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
@PerDataManager
@Component(dependencies = ApplicationComponent.class, modules = DataManagerModule.class)
public interface DataManagerComponent {

    void inject(DataManager dataManager);
}