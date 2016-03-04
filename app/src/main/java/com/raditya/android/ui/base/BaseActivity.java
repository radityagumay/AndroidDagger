package com.raditya.android.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.raditya.android.AndroidApplication;
import com.raditya.android.injection.component.ApplicationComponent;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initInjection();
    }

    private void initInjection(){
        applicationComponent().inject(this);
    }

    public ApplicationComponent applicationComponent() {
        return AndroidApplication.get(this).getComponent();
    }
}
