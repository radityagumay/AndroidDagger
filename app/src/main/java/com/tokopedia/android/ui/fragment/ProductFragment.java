package com.tokopedia.android.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tokopedia.android.R;
import com.tokopedia.android.ui.base.BaseFragment;

import butterknife.Bind;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
public class ProductFragment extends BaseFragment {

    @Bind(R.id.tv_product)
    TextView mTextView;

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
        int[] characterIds = new int[]{1, 2, 3};
        mSubscriptions.add(mDataManager.getCharacters(characterIds)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(mDataManager.getScheduler())
                .subscribe(new Subscriber<Character>() {
                    @Override
                    public void onCompleted() {
                        //Timber.d("onCompleted");
                        mTextView.setText("onCompleted");
                    }

                    @Override
                    public void onError(Throwable error) {
                        //Timber.e("There was an error retrieving the characters " + error);
                        mTextView.setText(error.getMessage());
                    }

                    @Override
                    public void onNext(Character character) {
                        //Timber.d("onNext :: " + character);
                        mTextView.setText(character);
                    }
                }));
    }
}
