package com.tokopedia.android.ui.presenter;

import com.google.common.collect.ImmutableList;
import com.tokopedia.android.network.api.ProductManager;
import com.tokopedia.android.service.Repository;
import com.tokopedia.android.ui.fragment.ProductFragment;
import com.tokopedia.android.utils.SimpleObserver;

import timber.log.Timber;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
public class ProductPresenter {

    private static final String TAG = ProductPresenter.class.getSimpleName();

    private ProductFragment productFragment;
    private ProductManager productManager;

    public ProductPresenter(ProductFragment productFragment,
                            ProductManager productManager) {
        this.productFragment = productFragment;
        this.productManager = productManager;
    }

    public void loadRepository() {
        productManager.getUsersRepositories()
                .subscribe(new SimpleObserver<ImmutableList<Repository>>() {
                    @Override
                    public void onNext(ImmutableList<Repository> repositories) {
                        //productFragment.showLoading(false);
                        productFragment.setRepositories(repositories);
                        Timber.d(TAG, "loadRepository : onNext");
                    }

                    @Override
                    public void onError(Throwable e) {
                        //productFragment.showLoading(false);
                        Timber.d(TAG, "loadRepository : onError");
                    }
                });
    }
}
