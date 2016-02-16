package com.tokopedia.android.service.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by raditya.gumay on 16/02/2016.
 */
public class BaseResponse {

    @SerializedName("status")
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static class Status {
        @SerializedName("error_code")
        private int errorCode;
        @SerializedName("message")
        private String message;

        public int getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(int errorCode) {
            this.errorCode = errorCode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
