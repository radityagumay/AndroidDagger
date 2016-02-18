package com.tokopedia.android.ui;

import java.util.List;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
public interface Callback<T> {
    public void onCompleted();

    public void onNext(T result);

    public void onError(Throwable throwable);
}
