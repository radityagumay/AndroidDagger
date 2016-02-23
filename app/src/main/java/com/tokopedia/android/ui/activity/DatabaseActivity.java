/*
package com.tokopedia.android.ui.activity;

import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

*/
/**
 * Created by raditya.gumay on 22/02/2016.
 *//*

public class DatabaseActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        insertData();
    }

    private void insertData() {
        ArrayList<ContentProviderOperation> provider = new ArrayList<>();
        provider.add(ContentProviderOperation.newInsert(DataContentProvider.PRODUCT_URI)
                .withValues(getContentValues())
                .withYieldAllowed(true)
                .build());

        try {
            getContentResolver().applyBatch(DataContentProvider.AUTHORITY, provider);
        } catch (Exception ex) {
            android.util.Log.e("DatabaseActivity", ex.getMessage());
        }
    }

    private ContentValues getContentValues() {
        List<DummyData> datas = getData();
        ContentValues values = null;
        */
/*for (int i = 0; i < datas.size(); i++) {
            values = new ContentValues();
            values.put(ProductTable.COLUMN_IMAGE_URL, datas.get(i).imageUrl);
            values.put(ProductTable.COLUMN_NAME, datas.get(i).name);
            values.put(ProductTable.COLUMN_PRICE, datas.get(i).price);
            values.put(ProductTable.COLUMN_FOTTER, datas.get(i).bottomText);
        }*//*

        return values;
    }

    private List<DummyData> getData() {
        List<DummyData> datas = new ArrayList<DummyData>(10);
        for (int i = 0; i < 10; i++) {
            DummyData d = new DummyData();
            d.imageUrl = "http://cdn.klimg.com/merdeka.com/i/w/photonews/2012/09/14/90158/640x320/20120914142653-bashaer-othman-wali-kota-termuda-di-dunia-001-debby-restu-utomo.jpg";
            d.name = "bashaer othman " + i;
            d.price = "hello world" + i;
            d.bottomText = "world hello" + i;
            datas.add(d);
        }

        return datas;
    }

    public static class DummyData {
        public String imageUrl;
        public String name;
        public String price;
        public String bottomText;
    }
}
*/
