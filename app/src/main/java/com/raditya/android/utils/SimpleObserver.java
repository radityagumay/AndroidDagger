package com.raditya.android.utils;

import rx.Observer;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
public class SimpleObserver<T> implements Observer<T> {
    @Override
    public void onCompleted() {
        // TODO Override something
    }

    @Override
    public void onError(Throwable e) {
        // TODO Override something
    }

    @Override
    public void onNext(T t) {
        // TODO Override something
    }
}