package com.tokopedia.android.network;

import com.tokopedia.android.service.response.CatalogueResponse;
import com.tokopedia.android.service.response.ProductResponse;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
public interface RestService {

    @GET(ApiConstant.PRODUCT)
    Observable<ProductResponse> getProducts(
            // TODO PATH
    );

    @GET(ApiConstant.CATALOG)
    Observable<CatalogueResponse> getCatalog(
            // TODO PATH
    );
}
