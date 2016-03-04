package com.raditya.android.injection.component;

import com.raditya.android.injection.module.CatalogueModule;
import com.raditya.android.injection.scope.ActivityScope;
import com.raditya.android.ui.fragment.CatalogueFragment;

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
