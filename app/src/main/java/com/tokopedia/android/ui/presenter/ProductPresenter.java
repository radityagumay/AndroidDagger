package com.tokopedia.android.ui.presenter;

import android.view.View;
import android.widget.AdapterView;

import com.google.common.collect.ImmutableList;
import com.tokopedia.android.network.api.ProductManager;
import com.tokopedia.android.service.ProductModel;
import com.tokopedia.android.service.Repository;
import com.tokopedia.android.service.response.ProductResponse;
import com.tokopedia.android.ui.fragment.ProductFragment;
import com.tokopedia.android.ui.utils.AppConstant;
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

    public void onResume() {
        // TODO do want do you want here
    }

    public void onDestroy() {
        // TODO do want do you want here
    }

    /**
     * Api, is kind of you call the cloud data
     * the best practice to implement call of data is
     * async call both of repo and api
     * usually we need a time {connect time out and read time out}
     * to establish and retrieve the data from the cloud services
     */
    public void loadProductApi() {

    }

    /**
     * Repository, is kind of you call the local data
     * such as Database
     */
    public void loadProductRepository() {
        productManager.getProductApis()
                .subscribe(new SimpleObserver<ProductResponse>() {
                    @Override
                    public void onNext(ProductResponse productResponse) {
                        super.onNext(productResponse);
                        Timber.d(AppConstant.TAG, "loadProductRepository size :" + productResponse.data.size());
                        productFragment.setProducts(productResponse);
                    }

                    @Override
                    public void onCompleted() {
                        super.onCompleted();
                        Timber.d(AppConstant.TAG, "loadProductRepository onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        Timber.e(AppConstant.TAG, "loadProductRepository " + e.getMessage());
                    }
                });
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

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // TODO
    }
}
