package com.raditya.android.network.api.manager;

import com.raditya.android.network.RestService;
import com.raditya.android.service.response.CatalogueResponse;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by raditya.gumay on 19/02/2016.
 */
public class CatalogueManager {

    private RestService mRestService;

    public CatalogueManager(RestService restService) {
        this.mRestService = restService;
    }

    public Observable<CatalogueResponse> getCatalogueRepository() {
        return mRestService.getCatalog()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
