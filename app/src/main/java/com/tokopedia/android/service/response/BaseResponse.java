package com.tokopedia.android.service.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by raditya.gumay on 16/02/2016.
 * Maybe, you think. why i am not use encapsulation.
 * here the explanation
 *
 * @link http://blog.leocad.io/why-you-shouldnt-use-getters-and-setters-on-android/
 */
public class BaseResponse {

    @SerializedName("status")
    public Status status;

    public static class Status {
        @SerializedName("error_code")
        public int errorCode;
        @SerializedName("message")
        public String message;
    }
}
