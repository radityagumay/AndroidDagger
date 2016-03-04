package com.raditya.android.service.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raditya.gumay on 19/02/2016.
 */
public class CatalogueResponse extends BaseResponse implements Parcelable {

    @SerializedName("data")
    public List<Data> data;

    public CatalogueResponse() {
        this.data = new ArrayList<>();
    }

    protected CatalogueResponse(Parcel in) {
        data = in.createTypedArrayList(Data.CREATOR);
    }

    public static final Creator<CatalogueResponse> CREATOR = new Creator<CatalogueResponse>() {
        @Override
        public CatalogueResponse createFromParcel(Parcel in) {
            return new CatalogueResponse(in);
        }

        @Override
        public CatalogueResponse[] newArray(int size) {
            return new CatalogueResponse[size];
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
        @SerializedName("price_min")
        public String price_min;
        @SerializedName("count_product")
        public int count_product;
        @SerializedName("description")
        public String description;
        @SerializedName("image_uri")
        public String image_uri;
        @SerializedName("uri")
        public String uri;

        protected Data(Parcel in) {
            id = in.readInt();
            name = in.readString();
            price_min = in.readString();
            count_product = in.readInt();
            description = in.readString();
            image_uri = in.readString();
            uri = in.readString();
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
            dest.writeString(price_min);
            dest.writeInt(count_product);
            dest.writeString(description);
            dest.writeString(image_uri);
            dest.writeString(uri);
        }
    }
}
