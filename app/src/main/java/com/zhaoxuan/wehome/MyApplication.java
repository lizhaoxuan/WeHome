package com.zhaoxuan.wehome;

import android.app.Application;

import com.zhaoxuan.wehome.support.dto.UserDto;

/**
 * Created by lizhaoxuan on 15/11/12.
 */
public class MyApplication extends Application {

    private static MyApplication mInstance = null;

    public static MyApplication getInstance(){
        return mInstance;
    }

    private UserDto userDto = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }


    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
