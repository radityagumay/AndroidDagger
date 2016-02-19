package com.tokopedia.android.injection.module;

import com.tokopedia.android.injection.scope.UserScope;
import com.tokopedia.android.network.RestService;
import com.tokopedia.android.network.api.ProductManager;
import com.tokopedia.android.service.User;

import dagger.Module;
import dagger.Provides;

/**
 * Created by raditya.gumay on 18/02/2016.
 */
@Module
public class UserModule {

    private User user;

    public UserModule(User user) {
        this.user = user;
    }

    @Provides
    @UserScope
    User provideUser() {
        return user;
    }

    @Provides
    @UserScope
    ProductManager provideProductManager (RestService restService) {
        return new ProductManager(restService);
    }
}