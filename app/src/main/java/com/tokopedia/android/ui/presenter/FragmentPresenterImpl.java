package com.tokopedia.android.ui.presenter;

import com.tokopedia.android.ui.Callback;
import com.tokopedia.android.ui.interactor.FindItemsInteractor;
import com.tokopedia.android.ui.view.ProductView;

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
