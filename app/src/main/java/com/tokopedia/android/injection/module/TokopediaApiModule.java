package com.tokopedia.android.injection.module;

import android.app.Application;

import com.tokopedia.android.network.ApiConstant;
import com.tokopedia.android.network.RestService;
import com.tokopedia.android.network.api.UserManager;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.RxJavaCallAdapterFactory;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
@Module
public class TokopediaApiModule {

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient() {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();

        /**
         * You can implement this when in Debug mode
         */
        /*if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(logging);
        }*/

        builder.connectTimeout(ApiConstant.HTTP_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(ApiConstant.HTTP_READ_TIMEOUT, TimeUnit.MILLISECONDS);
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRestAdapter(Application application, OkHttpClient okHttpClient) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.client(okHttpClient)
                .baseUrl(ApiConstant.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());
        return builder.build();
    }

    @Provides
    @Singleton
    public RestService provideGithubApiService(Retrofit restAdapter) {
        return restAdapter.create(RestService.class);
    }

    @Provides
    @Singleton
    public UserManager provideUserManager(RestService githubApiService) {
        return new UserManager(githubApiService);
    }
}