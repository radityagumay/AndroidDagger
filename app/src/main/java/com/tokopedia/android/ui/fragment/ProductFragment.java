package com.tokopedia.android.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.common.collect.ImmutableList;
import com.tokopedia.android.R;
import com.tokopedia.android.service.Repository;
import com.tokopedia.android.ui.base.BaseFragment;
import com.tokopedia.android.ui.presenter.ProductPresenter;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
public class ProductFragment extends BaseFragment {

    @Inject
    ProductPresenter mPresenter;

    @Bind(R.id.tv_product)
    TextView mTextView;

    private Activity mActivity;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public static ProductFragment newInstance(String param1, String param2) {
        ProductFragment fragment = new ProductFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ProductFragment() {
        //TODO
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_product, container, false);
        return fragmentView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        callService();
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_product;
    }

    private void callService() {
        mPresenter.loadRepository();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public void showLoading(boolean loading) {
        Toast.makeText(mActivity, loading ? "true" : "false", Toast.LENGTH_SHORT).show();
    }

    public void setRepositories(ImmutableList<Repository> repositories) {
        Toast.makeText(mActivity, repositories.get(0).name, Toast.LENGTH_SHORT).show();
    }
}
