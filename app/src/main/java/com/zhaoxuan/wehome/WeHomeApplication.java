package com.zhaoxuan.wehome;

import android.app.Application;

import com.zhaoxuan.cakedao.CakeDao;

/**
 * Created by lizhaoxuan on 15/11/12.
 */
public class WeHomeApplication extends Application {
    private static final String TAG = WeHomeApplication.class.getName();


    private static WeHomeApplication mInstance = null;

    public static WeHomeApplication getInstance() {
        return mInstance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initDB();
    }

    protected void initDB() {
        String dbName = "home_db";
        int version = 1;
        CakeDao.init(this, dbName, version, true);
    }

}
