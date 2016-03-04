package com.raditya.android.injection.component;

import com.raditya.android.injection.module.ApplicationModule;
import com.raditya.android.injection.module.CatalogueModule;
import com.raditya.android.injection.module.ProductModule;
import com.raditya.android.injection.module.ApiModule;
import com.raditya.android.ui.base.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                ApiModule.class,
        }
)
public interface ApplicationComponent {

    void inject(BaseActivity baseActivity);

    ProductComponent plus(ProductModule productModule);
    CatalogueComponent plus(CatalogueModule catalogueModule);
}