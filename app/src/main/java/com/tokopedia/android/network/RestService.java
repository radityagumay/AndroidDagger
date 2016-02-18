package com.tokopedia.android.network;

import com.tokopedia.android.service.response.BaseResponse;
import com.tokopedia.android.service.response.ProductResponse;
import com.tokopedia.android.service.response.RepositoryResponse;
import com.tokopedia.android.service.response.UserResponse;

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

    @GET("/people/{personId}")
    Observable<com.tokopedia.android.service.Character> getCharacter(@Path("personId") int id);

    @GET("/users/{username}/repos")
    Observable<List<RepositoryResponse>> getUsersRepositories(
            @Path("username") String username
    );

    @GET("/users/{username}")
    Observable<UserResponse> getUser(
            @Path("username") String username
    );
}
