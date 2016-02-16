package com.tokopedia.android.injection.module;

import com.tokopedia.android.injection.scope.ActivityScope;
import com.tokopedia.android.network.api.ProductManager;
import com.tokopedia.android.ui.fragment.ProductFragment;
import com.tokopedia.android.ui.presenter.ProductPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
@Module
public class ProductFragmentModule {
    private ProductFragment productFragment;

    public ProductFragmentModule(ProductFragment productFragment) {
        this.productFragment = productFragment;
    }

    @Provides
    @ActivityScope
    ProductFragment provideRepositoriesListActivity() {
        return productFragment;
    }

    @Provides
    @ActivityScope
    ProductPresenter provideRepositoriesListActivityPresenter(ProductManager productManager) {
        return new ProductPresenter(productFragment, productManager);
    }
}
