package com.tokopedia.android.ui.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tokopedia.android.injection.data.DataManager;

import butterknife.ButterKnife;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
public abstract class BaseFragment extends Fragment {

    protected CompositeSubscription mSubscriptions;
    protected DataManager mDataManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initInjection();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(getFragmentLayout(), container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initInjectView(view);
    }

    private void initInjectView(final View view) {
        ButterKnife.bind(this, view);
    }

    private void initInjection() {
        ((BaseActivity) getActivity()).applicationComponent().inject(this);

        mSubscriptions = new CompositeSubscription();
        mDataManager = ((BaseActivity) getActivity()).applicationComponent().dataManager();
    }

    protected abstract int getFragmentLayout();
}
