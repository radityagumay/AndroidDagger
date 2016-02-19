package com.tokopedia.android.injection.component;

import com.tokopedia.android.injection.module.CatalogueModule;
import com.tokopedia.android.injection.scope.ActivityScope;
import com.tokopedia.android.ui.fragment.CatalogueFragment;

import dagger.Subcomponent;

/**
 * Created by raditya.gumay on 19/02/2016.
 */
@ActivityScope
@Subcomponent(
        modules = {
                CatalogueModule.class
        }
)
public interface CatalogueComponent {
    CatalogueFragment inject(CatalogueFragment catalogueFragment);
}
