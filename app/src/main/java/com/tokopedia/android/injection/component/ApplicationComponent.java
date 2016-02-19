package com.tokopedia.android.injection.component;

import com.tokopedia.android.injection.module.ApplicationModule;
import com.tokopedia.android.injection.module.ProductModule;
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
        }
)
public interface ApplicationComponent {

    void inject(BaseActivity baseActivity);

    ProductComponent plus(ProductModule productModule);
}