package com.raditya.android.ui.view;

import java.util.List;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
public interface ProductView {
    public void showProgress();
    public void hideProgress();
    public void setItems(List<String> items);
    public void showMessage(String message);
}
