package com.raditya.android.ui.presenter;

import android.widget.Toast;

import com.raditya.android.AndroidApplication;
import com.raditya.android.injection.component.ApplicationComponent;
import com.raditya.android.injection.module.ApplicationModule;
import com.raditya.android.network.api.manager.CatalogueManager;
import com.raditya.android.service.response.CatalogueResponse;
import com.raditya.android.ui.fragment.CatalogueFragment;
import com.raditya.android.utils.SimpleObserver;

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
                        mCatalogueFragment.setCatalogueDatas(catalogueResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        Toast.makeText(AndroidApplication.getContext(), "Just Implement Model", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
