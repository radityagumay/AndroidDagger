package com.tokopedia.android.service.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raditya.gumay on 18/02/2016.
 */
public class ProductResponse extends BaseResponse {

    @SerializedName("data")
    public Data data;

    public static class Data {
        @SerializedName("id")
        public int id;
        @SerializedName("name")
        public String name;
        @SerializedName("uri")
        public String uri;
        @SerializedName("image_uri")
        public String imageUri;
        @SerializedName("price")
        public String price;
        @SerializedName("shop")
        public Shop shop;
        @SerializedName("wholesale_price")
        public List<WholesalePrice> wholesalePrice;
        @SerializedName("condition")
        public int condition;

        public Data() {
            wholesalePrice = new ArrayList<>();
        }

        public static class WholesalePrice {
            @SerializedName("count_min")
            public int countMin;
            @SerializedName("count_max")
            public int countMax;
            @SerializedName("price")
            public String price;
        }

        public static class Shop {
            @SerializedName("id")
            public int id;
            @SerializedName("name")
            public String name;
            @SerializedName("uri")
            public String uri;
            @SerializedName("is_gold")
            public int isGold;
            @SerializedName("rating")
            public Rating rating;
            @SerializedName("location")
            public String location;
            @SerializedName("reputation_image_uri")
            public String reputationImageUri;
            @SerializedName("shop_lucky")
            public String shopLucky;

            public static class Rating {
                @SerializedName("speed")
                public int speed;
                @SerializedName("accuracy")
                public int accuracy;
                @SerializedName("service")
                public int service;
                @SerializedName("reputation_score")
                public int reputationScore;
                @SerializedName("reputation_set")
                public int reputationSet;
                @SerializedName("reputation_level")
                public int reputationLevel;
            }
        }
    }
}
