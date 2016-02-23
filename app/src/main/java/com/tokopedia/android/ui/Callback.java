package com.tokopedia.android.ui;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
public interface Callback<T> {
    public void onSuccess(T result);

    public void onError(Throwable throwable);
}
