package com.tokopedia.android.service.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raditya.gumay on 18/02/2016.
 */
public class ProductResponse extends BaseResponse implements
        Parcelable {

    @SerializedName("data")
    public List<Data> data;

    public ProductResponse() {
        this.data = new ArrayList<>();
    }

    protected ProductResponse(Parcel in) {
        data = in.createTypedArrayList(Data.CREATOR);
    }

    public static final Creator<ProductResponse> CREATOR = new Creator<ProductResponse>() {
        @Override
        public ProductResponse createFromParcel(Parcel in) {
            return new ProductResponse(in);
        }

        @Override
        public ProductResponse[] newArray(int size) {
            return new ProductResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.data);
    }

    public static class Data implements Parcelable {
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
        public List<WholesalePrice> wholesalePrice = new ArrayList<>();
        @SerializedName("condition")
        public int condition;

        public Data(){

        }

        protected Data(Parcel in) {
            id = in.readInt();
            name = in.readString();
            uri = in.readString();
            imageUri = in.readString();
            price = in.readString();
            condition = in.readInt();
            wholesalePrice = in.createTypedArrayList(WholesalePrice.CREATOR);
        }

        public static final Creator<Data> CREATOR = new Creator<Data>() {
            @Override
            public Data createFromParcel(Parcel in) {
                return new Data(in);
            }

            @Override
            public Data[] newArray(int size) {
                return new Data[size];
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
            dest.writeList(wholesalePrice);
        }

        public static class WholesalePrice implements Parcelable {
            @SerializedName("count_min")
            public int countMin;
            @SerializedName("count_max")
            public int countMax;
            @SerializedName("price")
            public String price;

            protected WholesalePrice(Parcel in) {
                countMin = in.readInt();
                countMax = in.readInt();
                price = in.readString();
            }

            public static final Creator<WholesalePrice> CREATOR = new Creator<WholesalePrice>() {
                @Override
                public WholesalePrice createFromParcel(Parcel in) {
                    return new WholesalePrice(in);
                }

                @Override
                public WholesalePrice[] newArray(int size) {
                    return new WholesalePrice[size];
                }
            };

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(countMin);
                dest.writeInt(countMax);
                dest.writeString(price);
            }
        }

        public static class Shop implements Parcelable{
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

            protected Shop(Parcel in) {
                id = in.readInt();
                name = in.readString();
                uri = in.readString();
                isGold = in.readInt();
                location = in.readString();
                reputationImageUri = in.readString();
                shopLucky = in.readString();
            }

            public static final Creator<Shop> CREATOR = new Creator<Shop>() {
                @Override
                public Shop createFromParcel(Parcel in) {
                    return new Shop(in);
                }

                @Override
                public Shop[] newArray(int size) {
                    return new Shop[size];
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
                dest.writeInt(isGold);
                dest.writeString(location);
                dest.writeString(reputationImageUri);
                dest.writeString(shopLucky);
            }

            public static class Rating implements Parcelable {
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

                protected Rating(Parcel in) {
                    speed = in.readInt();
                    accuracy = in.readInt();
                    service = in.readInt();
                    reputationScore = in.readInt();
                    reputationSet = in.readInt();
                    reputationLevel = in.readInt();
                }

                public static final Creator<Rating> CREATOR = new Creator<Rating>() {
                    @Override
                    public Rating createFromParcel(Parcel in) {
                        return new Rating(in);
                    }

                    @Override
                    public Rating[] newArray(int size) {
                        return new Rating[size];
                    }
                };

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeInt(speed);
                    dest.writeInt(accuracy);
                    dest.writeInt(service);
                    dest.writeInt(reputationScore);
                    dest.writeInt(reputationSet);
                    dest.writeInt(reputationLevel);
                }
            }
        }
    }
}
