package com.tokopedia.android.injection.component;

import com.tokopedia.android.database.DatabaseRealm;
import com.tokopedia.android.injection.module.ApplicationModule;
import com.tokopedia.android.injection.module.CatalogueModule;
import com.tokopedia.android.injection.module.ProductModule;
import com.tokopedia.android.injection.module.RepositoryModule;
import com.tokopedia.android.injection.module.TokopediaApiModule;
import com.tokopedia.android.ui.base.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                TokopediaApiModule.class,
                RepositoryModule.class
        }
)
public interface ApplicationComponent {

    void inject(BaseActivity baseActivity);

    void inject(DatabaseRealm databaseRealm);

    /**
     * Put your custom module here
     */
    ProductComponent plus(ProductModule productModule);

    CatalogueComponent plus(CatalogueModule catalogueModule);
}