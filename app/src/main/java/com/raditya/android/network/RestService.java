package com.raditya.android.network;

import com.raditya.android.service.response.CatalogueResponse;
import com.raditya.android.service.response.ProductResponse;
import com.raditya.android.service.response.RepositoryResponse;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
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

    @GET("/users/{username}/repos")
    Observable<List<RepositoryResponse>> getUsersRepositories(
            @Path("username") String username
    );
}
