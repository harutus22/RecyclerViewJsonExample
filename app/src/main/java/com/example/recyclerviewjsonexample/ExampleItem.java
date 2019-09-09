package com.example.recyclerviewjsonexample;

import android.os.Parcel;
import android.os.Parcelable;

public class ExampleItem implements Parcelable {
    private String mImageUrl;
    private String mCreator;
    private int mLikes;
    private int mViews;

    public ExampleItem(){}

    public ExampleItem(String mImageUrl, String mCreator, int mLikes, int mViews) {
        this.mImageUrl = mImageUrl;
        this.mCreator = mCreator;
        this.mLikes = mLikes;
        this.mViews = mViews;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public String getmCreator() {
        return mCreator;
    }

    public int getmLikes() {
        return mLikes;
    }

    public int getmViews() {
        return mViews;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mImageUrl);
        parcel.writeString(mCreator);
        parcel.writeInt(mLikes);
        parcel.writeInt(mViews);
    }

    public static final Creator<ExampleItem> CREATOR = new Creator<ExampleItem>() {
        @Override
        public ExampleItem createFromParcel(Parcel parcel) {
            return ExampleItem.createFromParcel(parcel);
        }

        @Override
        public ExampleItem[] newArray(int i) {
            return new ExampleItem[i];
        }
    };

    private static ExampleItem createFromParcel(Parcel in){
        ExampleItem exampleItem = new ExampleItem();
        exampleItem.mImageUrl = in.readString();
        exampleItem.mCreator = in.readString();
        exampleItem.mLikes = in.readInt();
        exampleItem.mViews = in.readInt();
        return exampleItem;
    }
}
