package com.tokopedia.android.injection.module;

import com.tokopedia.android.injection.scope.ActivityScope;
import com.tokopedia.android.injection.scope.UserScope;
import com.tokopedia.android.network.RestService;
import com.tokopedia.android.network.api.ProductManager;
import com.tokopedia.android.service.User;
import com.tokopedia.android.ui.fragment.ProductFragment;
import com.tokopedia.android.ui.interactor.FindItemsInteractor;
import com.tokopedia.android.ui.presenter.ProductPresenter;
import com.tokopedia.android.ui.presenter.FragmentPresenterImpl;
import com.tokopedia.android.ui.view.ProductView;

import javax.inject.Singleton;

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
    ProductFragment provideRepositoriesListActivity() {
        return productFragment;
    }

    @Provides
    @ActivityScope
    ProductPresenter provideRepositoriesListActivityPresenter(ProductManager productManager) {
        return new ProductPresenter(productFragment, productManager);
    }

    @Provides
    @ActivityScope
    ProductManager provideProductManager (RestService restService) {
        return new ProductManager(restService);
    }
}
