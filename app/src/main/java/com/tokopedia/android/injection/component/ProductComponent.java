package com.tokopedia.android.injection.component;

import com.tokopedia.android.injection.module.ProductModule;
import com.tokopedia.android.injection.scope.ActivityScope;
import com.tokopedia.android.ui.fragment.ProductFragment;

import dagger.Subcomponent;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
@ActivityScope
@Subcomponent(
        modules = ProductModule.class
)
public interface ProductComponent {
    ProductFragment inject(ProductFragment repositoriesListActivity);
}
