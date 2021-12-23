package com.example.themovieappservinformacion.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class BaseResponse<T> implements Parcelable {

        public static final String BASE_RESPONSE_STATUS_CODE = "id";
        public static final String BASE_RESPONSE_RESULT = "result";
        private static final String BASE_RESPONSE_JSON = "jsonrcp";


        @SerializedName(BASE_RESPONSE_STATUS_CODE)
        String id;
        @SerializedName(BASE_RESPONSE_RESULT)
        T result;
        @SerializedName(BASE_RESPONSE_JSON)
        String jsonrcp;


        protected BaseResponse(Parcel in) {
            id = in.readString();
            jsonrcp = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(jsonrcp);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<BaseResponse> CREATOR = new Creator<BaseResponse>() {
            @Override
            public BaseResponse createFromParcel(Parcel in) {
                return new BaseResponse(in);
            }

            @Override
            public BaseResponse[] newArray(int size) {
                return new BaseResponse[size];
            }
        };

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public T getResult() {
            return result;
        }

        public void setResult(T result) {
            this.result = result;
        }

        public String getJsonrcp() {
            return jsonrcp;
        }

        public void setJsonrcp(String jsonrcp) {
            this.jsonrcp = jsonrcp;
        }
    }

