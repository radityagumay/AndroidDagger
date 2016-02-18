package com.tokopedia.android.ui.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tokopedia.android.TokopediaApplication;
import com.tokopedia.android.injection.module.ProductModule;

import butterknife.ButterKnife;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //initInjection();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getFragmentLayout(), container, false);;
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initInjectView(view);
    }

    private void initInjectView(final View view) {
        ButterKnife.bind(this, view);
        ButterKnife.setDebug(true);
    }

    private void initInjection() {
        /**
         * You can use as global injection
         */
        //((BaseActivity) getActivity()).applicationComponent().inject(this);

        /**
         * Either you can use as specified injection
         */
        /*TokopediaApplication.get(this).getUserComponent()
                .plus(new ProductModule(this))
                .inject(this);*/
    }

    protected abstract int getFragmentLayout();
}
