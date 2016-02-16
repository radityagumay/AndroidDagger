package com.tokopedia.android.ui.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.tokopedia.android.TokopediaApplication;
import com.tokopedia.android.injection.component.ApplicationComponent;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected ApplicationComponent applicationComponent() {
        return TokopediaApplication.get(this).getComponent();
    }
}
