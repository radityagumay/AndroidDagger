package com.tokopedia.android.injection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by raditya.gumay on 16/02/2016.
 * A scoping annotation to permit objects whose lifetime should
 * conform to the life of the DataManager to be memorised in the
 * correct component.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerDataManager {

}