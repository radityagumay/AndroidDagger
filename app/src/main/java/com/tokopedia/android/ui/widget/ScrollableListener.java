package com.tokopedia.android.ui.widget;

import android.view.View;
import android.widget.AbsListView;

/**
 * Created by raditya.gumay on 18/02/2016.
 */
public abstract class ScrollableListener implements AbsListView.OnScrollListener {

    private int page = 0;
    private int previousTotal = 0;
    private int oldTop;
    private int oldFirstVisibleItem;

    public ScrollableListener() {
        //TODO
    }

    public ScrollableListener(int page) {
        this.page = page;
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        View v = view.getChildAt(0);
        int top = (v == null) ? 0 : v.getTop();
        if (firstVisibleItem == oldFirstVisibleItem) {
            if (top > oldTop) {
            } else if (top < oldTop) {
                previousTotal = totalItemCount;
                previousTotal += 1;
                OnNextPage(previousTotal);
            }
        } else {
            if (firstVisibleItem < oldFirstVisibleItem) {
            } else {
                previousTotal = totalItemCount;
                previousTotal += 1;
                OnNextPage(previousTotal);
            }
        }
        oldTop = top;
        oldFirstVisibleItem = firstVisibleItem;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
    }

    public abstract void OnNextPage(int page);
}
