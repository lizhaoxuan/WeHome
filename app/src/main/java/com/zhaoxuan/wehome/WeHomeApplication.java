package com.zhaoxuan.wehome;

import android.app.Application;

import com.zhaoxuan.wehome.module.log.WLog;
import com.zhaoxuan.wehome.support.dto.UserDto;

/**
 * Created by lizhaoxuan on 15/11/12.
 */
public class WeHomeApplication extends Application {
    private static final String TAG = WeHomeApplication.class.getName();

    private static WeHomeApplication mInstance = null;

    public static WeHomeApplication getInstance(){
        return mInstance;
    }

    private UserDto userDto = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }


    public UserDto getUserDto() {
        if (userDto==null){
            WLog.w(TAG,"userDto == null");
            return null;
        }else{
            return userDto;
        }

    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
