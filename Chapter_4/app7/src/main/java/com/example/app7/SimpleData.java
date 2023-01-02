package com.example.app7;

import android.os.Parcel;
import android.os.Parcelable;

public class SimpleData implements Parcelable {

    String id;
    String pw;

    public SimpleData(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public SimpleData(Parcel src) {
        id = src.readString();
        pw = src.readString();
    }

    public static final Parcelable.Creator CREATOR = new Creator() {

        @Override
        public SimpleData createFromParcel(Parcel in) {
            return new SimpleData(in);
        }

        @Override
        public SimpleData[] newArray(int size) {
            return new SimpleData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(pw);
    }
}
