package com.tokopedia.android.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.common.collect.ImmutableList;
import com.tokopedia.android.R;
import com.tokopedia.android.TokopediaApplication;
import com.tokopedia.android.injection.module.ProductModule;
import com.tokopedia.android.service.ProductModel;
import com.tokopedia.android.service.Repository;
import com.tokopedia.android.service.response.ProductResponse;
import com.tokopedia.android.ui.adapter.GridViewAdapter;
import com.tokopedia.android.ui.base.BaseActivity;
import com.tokopedia.android.ui.base.BaseFragment;
import com.tokopedia.android.ui.presenter.ProductPresenter;
import com.tokopedia.android.ui.utils.AppConstant;
import com.tokopedia.android.ui.widget.ScrollableListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import timber.log.Timber;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
public class ProductFragment extends BaseFragment implements
        AdapterView.OnItemClickListener {

    @Inject
    ProductPresenter mPresenter;

    @Bind(R.id.product_horizontal_grid)
    GridView mGridView;

    private GridViewAdapter mGridViewAdapter;
    private ProductResponse mProductResponse;

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
        ((BaseActivity) getActivity())
                .applicationComponent()
                .plus(new ProductModule(this))
                .inject(this);
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
        setupGridView();
        callService();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_product;
    }

    private void setupGridView() {
        mProductResponse = new ProductResponse();
        mGridViewAdapter = new GridViewAdapter(mActivity, mProductResponse);

        mGridView.setAdapter(mGridViewAdapter);
        mGridView.setOnItemClickListener(this);
        mGridView.setOnScrollListener(scrollableListener);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void callService() {
        mPresenter.loadProductRepository();
    }

    public void showLoading(boolean loading) {
        //TODO do something
    }

    public void setRepositories(ImmutableList<Repository> repositories) {
        Toast.makeText(mActivity, repositories.get(0).name, Toast.LENGTH_SHORT).show();
    }

    public void setProducts(ProductResponse products) {
        mProductResponse.data.addAll(products.data);
        mGridViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mPresenter.onItemClick(parent, view, position, id);
    }

    public void loadMoreProducts(int page) {

    }

    private ScrollableListener scrollableListener = new ScrollableListener() {
        @Override
        public void OnNextPage(int page) {

        }
    };
}
