package com.tokopedia.android.ui.presenter;

import com.tokopedia.android.network.api.manager.CatalogueManager;
import com.tokopedia.android.service.response.CatalogueResponse;
import com.tokopedia.android.ui.fragment.CatalogueFragment;
import com.tokopedia.android.utils.SimpleObserver;

/**
 * Created by raditya.gumay on 18/02/2016.
 */
public class CataloguePresenter {

    private CatalogueFragment mCatalogueFragment;
    private CatalogueManager mCatalogueManager;

    public CataloguePresenter(CatalogueFragment catalogueFragment,
                              CatalogueManager catalogueManager) {
        this.mCatalogueFragment = catalogueFragment;
        this.mCatalogueManager = catalogueManager;
    }

    public void onResume() {
        // TODO
    }

    public void onDestroy() {
        // TODO
    }

    public void LoadCatalogueRepository(){
        mCatalogueManager.getCatalogueRepository()
                .subscribe(new SimpleObserver<CatalogueResponse>(){
                    @Override
                    public void onCompleted() {
                        super.onCompleted();
                    }

                    @Override
                    public void onNext(CatalogueResponse catalogueResponse) {
                        super.onNext(catalogueResponse);
                        //mCatalogueFragment.setCatalogueDatas(catalogueResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                    }
                });
    }
}
