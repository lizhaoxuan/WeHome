package com.zhaoxuan.wehome;

import android.app.Application;

/**
 * Created by lizhaoxuan on 15/11/12.
 */
public class MyApplication extends Application {

    private static MyApplication mInstance = null;

    public static MyApplication getInstance(){
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
}
