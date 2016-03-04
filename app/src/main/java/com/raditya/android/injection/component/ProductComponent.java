package com.raditya.android.injection.component;

import com.raditya.android.injection.module.ProductModule;
import com.raditya.android.injection.scope.ActivityScope;
import com.raditya.android.ui.fragment.ProductFragment;

import dagger.Subcomponent;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
@ActivityScope
@Subcomponent(
        modules = ProductModule.class
)
public interface ProductComponent {
    ProductFragment inject(ProductFragment productFragment);
}
