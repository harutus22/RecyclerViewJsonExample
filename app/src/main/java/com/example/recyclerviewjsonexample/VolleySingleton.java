package com.example.recyclerviewjsonexample;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {
    private static VolleySingleton mVoleySingleton;
    private RequestQueue mRequestQueue;

    private VolleySingleton(Context context){
        mRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public static VolleySingleton getInstance(Context context){
        if(mVoleySingleton == null){
            mVoleySingleton = new VolleySingleton(context);
        }
        return mVoleySingleton;
    }

    public RequestQueue getmRequestQueue(){
        return mRequestQueue;
    }
}
