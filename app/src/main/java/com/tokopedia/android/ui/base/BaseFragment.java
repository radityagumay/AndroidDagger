package com.tokopedia.android.ui.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tokopedia.android.AppConfig;

import butterknife.ButterKnife;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getFragmentLayout(), container, false);
        ;
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initInjectView(view);
    }

    private void initInjectView(final View view) {
        ButterKnife.bind(this, view);
        ButterKnife.setDebug(AppConfig.APPLICATION_DEBUG);
    }

    protected abstract int getFragmentLayout();
}
