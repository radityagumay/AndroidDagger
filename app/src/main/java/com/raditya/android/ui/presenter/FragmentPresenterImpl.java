package com.raditya.android.ui.presenter;

import com.raditya.android.ui.interactor.FindItemsInteractor;
import com.raditya.android.ui.view.ProductView;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
public class FragmentPresenterImpl {

    private ProductView mainView;
    private FindItemsInteractor findItemsInteractor;

    public FragmentPresenterImpl(ProductView mainView, FindItemsInteractor findItemsInteractor) {
        this.mainView = mainView;
        this.findItemsInteractor = findItemsInteractor;
    }
}
