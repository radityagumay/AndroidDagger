package com.tokopedia.android.network.api;

import com.tokopedia.android.network.RestService;
import com.tokopedia.android.service.response.ProductResponse;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
public class ProductManager {

    private RestService restService;

    public ProductManager(RestService restService) {
        this.restService = restService;
    }

    /**
     * Simple get
     * @return
     */
    public Observable<ProductResponse> getProductRepository() {
        return restService.getProducts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
