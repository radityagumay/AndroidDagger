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

    public void onResume(){
        // TODO do want do you want here
    }

    public void onDestroy(){
        // TODO do want do you want here
    }

    /**
     * Api, is kind of you call the cloud data
     * the best practice to implement call of data is
     * async call both of repo and api
     * usually we need a time {connect time out and read time out}
     * to establish and retrieve the data from the cloud services
     */
    public void loadProductApi(){

    }

    /**
     * Repository, is kind of you call the local data
     * such as Database
     */
    public void loadProductRepository(){

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
