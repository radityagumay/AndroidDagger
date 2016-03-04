package com.raditya.android.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.raditya.android.ui.fragment.CatalogueFragment;
import com.raditya.android.ui.fragment.ProductFragment;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
public class MainSectionsPagerAdapter extends FragmentPagerAdapter {

    private static final String[] TITLE = new String[]{
            "Product",
            "Katalog",
            "Toko",
    };

    public MainSectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ProductFragment.newInstance("", "");
            case 1:
                return CatalogueFragment.newInstance("", "");
            case 2:
                return ProductFragment.newInstance("", "");
            default:
                return ProductFragment.newInstance("", "");
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLE[position];
    }

    @Override
    public int getCount() {
        return TITLE.length;
    }
}
