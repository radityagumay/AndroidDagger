package com.tokopedia.android.injection.component;

import android.app.Application;

import com.squareup.otto.Bus;
import com.tokopedia.android.injection.module.ApplicationModule;
import com.tokopedia.android.injection.module.ProductModule;
import com.tokopedia.android.injection.module.TokopediaApiModule;
import com.tokopedia.android.injection.module.UserModule;
import com.tokopedia.android.ui.activity.MainActivity;
import com.tokopedia.android.ui.base.BaseActivity;
import com.tokopedia.android.ui.base.BaseFragment;

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

    void inject(MainActivity mainActivity);

    void inject(BaseFragment baseFragment);

    void inject(BaseActivity baseActivity);

    Application application();

    //UserComponent plus(UserModule userModule);

    ProductComponent plus(ProductModule productModule);
}