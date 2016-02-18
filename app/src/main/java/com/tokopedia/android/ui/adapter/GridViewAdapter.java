package com.tokopedia.android.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tokopedia.android.R;
import com.tokopedia.android.service.response.ProductResponse;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by raditya.gumay on 18/02/2016.
 */
public class GridViewAdapter extends BaseAdapter {

    private Context mContext;
    private ProductResponse mList;

    public GridViewAdapter(Context context, ProductResponse list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList.data.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        if (convertView != null) {
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.adapter_item_product, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }

        if (!TextUtils.isEmpty(mList.data.get(position).imageUri)) {
            Glide.with(mContext)
                    .load(mList.data.get(position).imageUri)
                    .into(viewHolder.mImageView);
        }

        if (!TextUtils.isEmpty(mList.data.get(position).name)) {
            viewHolder.mTitleItem.setText(mList.data.get(position).name);
        }

        if (!TextUtils.isEmpty(mList.data.get(position).price)) {
            viewHolder.mTitleItem.setText(mList.data.get(position).price);
        }

        if (!TextUtils.isEmpty(mList.data.get(position).shop.name)) {
            viewHolder.mTitleItem.setText(mList.data.get(position).shop.name);
        }
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.iv_item)
        ImageView mImageView;
        @Bind(R.id.tv_title_item)
        TextView mTitleItem;
        @Bind(R.id.tv_price_item)
        TextView mPriceItem;
        @Bind(R.id.tv_shop_title)
        TextView mShopTitle;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}