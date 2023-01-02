package com.example.app5;

import android.os.Parcel;
import android.os.Parcelable;

public class SimpleData implements Parcelable {
    String id;
    String pw;

    public SimpleData(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    protected SimpleData(Parcel in) {
        id = in.readString();
        pw = in.readString();
    }

    public static final Creator<SimpleData> CREATOR = new Creator<SimpleData>() {
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
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(pw);
    }
}
