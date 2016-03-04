package com.raditya.android.injection.module;

import com.raditya.android.injection.scope.ActivityScope;
import com.raditya.android.network.RestService;
import com.raditya.android.network.api.manager.CatalogueManager;
import com.raditya.android.ui.fragment.CatalogueFragment;
import com.raditya.android.ui.presenter.CataloguePresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by raditya.gumay on 19/02/2016.
 */
@Module
public class CatalogueModule {

    private CatalogueFragment mCatalogueFragment;

    public CatalogueModule(CatalogueFragment catalogueFragment) {
        this.mCatalogueFragment = catalogueFragment;
    }

    @Provides
    @ActivityScope
    CatalogueFragment provideCatalogueFragment() {
        return mCatalogueFragment;
    }

    @Provides
    @ActivityScope
    CataloguePresenter provideCatalogueFragmentPresenter(CatalogueManager catalogueManager){
        return new CataloguePresenter(mCatalogueFragment, catalogueManager);
    }

    @Provides
    @ActivityScope
    CatalogueManager provideCatalogueManager(RestService restService){
        return new CatalogueManager(restService);
    }
}
