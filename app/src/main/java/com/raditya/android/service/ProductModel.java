package com.raditya.android.service;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raditya.gumay on 18/02/2016.
 */
public class ProductModel implements Parcelable {

    public int id;
    public String name;
    public String uri;
    public String imageUri;
    public String price;
    public Shop shop;
    public List<WholesalePrice> wholesalePrice;
    public int condition;

    public ProductModel() {
        this.wholesalePrice = new ArrayList<>();
    }

    protected ProductModel(Parcel in) {
        id = in.readInt();
        name = in.readString();
        uri = in.readString();
        imageUri = in.readString();
        price = in.readString();
        condition = in.readInt();
    }

    public static final Creator<ProductModel> CREATOR = new Creator<ProductModel>() {
        @Override
        public ProductModel createFromParcel(Parcel in) {
            return new ProductModel(in);
        }

        @Override
        public ProductModel[] newArray(int size) {
            return new ProductModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(uri);
        dest.writeString(imageUri);
        dest.writeString(price);
        dest.writeInt(condition);
    }

    public static class WholesalePrice {
        public int countMin;
        public int countMax;
        public String price;
    }

    public static class Shop {
        public int id;
        public String name;
        public String uri;
        public int isGold;
        public Rating rating;
        public String location;
        public String reputationImageUri;
        public String shopLucky;

        public static class Rating {
            public int speed;
            public int accuracy;
            public int service;
            public int reputationScore;
            public int reputationSet;
            public int reputationLevel;
        }
    }
}
