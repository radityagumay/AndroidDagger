package com.tokopedia.android.ui.presenter;

import android.view.View;
import android.widget.AdapterView;

import com.tokopedia.android.network.api.ProductManager;
import com.tokopedia.android.service.response.ProductResponse;
import com.tokopedia.android.ui.fragment.ProductFragment;
import com.tokopedia.android.ui.utils.AppConstant;
import com.tokopedia.android.utils.SimpleObserver;

import timber.log.Timber;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
public class ProductPresenter {

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

    public void loadProductRepository() {
        productManager.getProductRepository()
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

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // TODO
    }
}
