package com.tokopedia.android.network;

import com.tokopedia.android.service.response.BaseResponse;

import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
public interface RestService {

    @Headers(ApiConstant.CONTENT_TYPE_JSON)
    @GET(ApiConstant.PRODUCT)
    Observable<BaseResponse> getProduct();

    @Headers(ApiConstant.CONTENT_TYPE_JSON)
    @GET("/people/{personId}")
    Observable<Character> getCharacter(@Path("personId") int id);
}
