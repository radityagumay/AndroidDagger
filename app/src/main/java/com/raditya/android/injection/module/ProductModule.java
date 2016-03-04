package com.raditya.android.injection.module;

import com.raditya.android.injection.scope.ActivityScope;
import com.raditya.android.network.RestService;
import com.raditya.android.network.api.ProductManager;
import com.raditya.android.ui.fragment.ProductFragment;
import com.raditya.android.ui.presenter.ProductPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
@Module
public class ProductModule {
    private ProductFragment productFragment;

    public ProductModule(ProductFragment productFragment) {
        this.productFragment = productFragment;
    }

    @Provides
    @ActivityScope
    ProductFragment provideProductFragment() {
        return productFragment;
    }

    @Provides
    @ActivityScope
    ProductPresenter provideProductFragmentPresenter(ProductManager productManager) {
        return new ProductPresenter(productFragment, productManager);
    }

    @Provides
    @ActivityScope
    ProductManager provideProductManager (RestService restService) {
        return new ProductManager(restService);
    }
}
