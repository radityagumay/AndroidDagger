package com.tokopedia.android.injection.component;

import com.tokopedia.android.injection.module.ProductModule;
import com.tokopedia.android.injection.module.UserModule;
import com.tokopedia.android.injection.scope.UserScope;

import dagger.Subcomponent;

/**
 * Created by raditya.gumay on 18/02/2016.
 */
@UserScope
@Subcomponent(
        modules = {
                UserModule.class
        }
)
public interface UserComponent {
    ProductComponent plus(ProductModule module);
}