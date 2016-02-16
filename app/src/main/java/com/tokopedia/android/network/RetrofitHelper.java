package com.tokopedia.android.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
public class RetrofitHelper {

    /**
     * Place your inceptor here, like maybe you have any auth header
     * @return
     */
    private RequestInterceptor getRequestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                //TODO
            }
        };
    }

    private Gson getGson() {
        return new GsonBuilder()
                .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
                .create();
    }

    public RestService newAndroidBoilerplateService() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(ApiConstant.BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new GsonConverter(getGson()))
                .setRequestInterceptor(getRequestInterceptor())
                .build();
        return restAdapter.create(RestService.class);
    }
}
