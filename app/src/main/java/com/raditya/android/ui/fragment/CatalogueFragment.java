package com.raditya.android.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.raditya.android.R;
import com.raditya.android.injection.module.CatalogueModule;
import com.raditya.android.service.response.CatalogueResponse;
import com.raditya.android.ui.adapter.GridViewAdapter;
import com.raditya.android.ui.base.BaseActivity;
import com.raditya.android.ui.base.BaseFragment;
import com.raditya.android.ui.presenter.CataloguePresenter;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by raditya.gumay on 18/02/2016.
 */
public class CatalogueFragment extends BaseFragment implements
        AdapterView.OnItemClickListener {

    @Inject
    CataloguePresenter mPresenter;

    @Bind(R.id.product_horizontal_grid)
    GridView mGridView;

    private GridViewAdapter mGridViewAdapter;
    private CatalogueResponse mCatalogueResponse;

    private Activity mActivity;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public static CatalogueFragment newInstance(String param1, String param2) {
        CatalogueFragment fragment = new CatalogueFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public CatalogueFragment() {
        // TODO
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initInjection();
    }

    private void initInjection() {
        ((BaseActivity) getActivity())
                .applicationComponent()
                .plus(new CatalogueModule(this))
                .inject(this);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_catalogue, container, false);
        return fragmentView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupGridView();
        callService();
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_catalogue;
    }

    private void callService() {
        mPresenter.LoadCatalogueRepository();
    }

    private void setupGridView() {
        mCatalogueResponse = new CatalogueResponse();
        mGridViewAdapter = new GridViewAdapter(mActivity, mCatalogueResponse.data);

        mGridView.setAdapter(mGridViewAdapter);
        mGridView.setOnItemClickListener(this);
    }

    public void setCatalogueDatas(CatalogueResponse catalogueDatas) {
        mCatalogueResponse.data.addAll(catalogueDatas.data);
        mGridViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
