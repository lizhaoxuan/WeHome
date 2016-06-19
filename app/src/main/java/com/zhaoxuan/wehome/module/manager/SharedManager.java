package com.zhaoxuan.wehome.module.manager;

import android.content.Context;
import android.util.Log;

import com.zhaoxuan.wehome.WeHomeApplication;
import com.zhaoxuan.wehome.support.dto.UserDto;
import com.zhaoxuan.wehome.support.utils.PreferenceUtil;
import com.zhaoxuan.wehome.support.utils.StrUtils;

/**
 * Created by lizhaoxuan on 16/6/15.
 */
public class SharedManager {
    private static final String TAG = SharedManager.class.getSimpleName();
    private static final String PREFERENCE_NAME = "WE_HOME";
    private static final String USER = "USER";
    private static final String PHOTO = "PHOTO";

    private SharedManager() {

    }

    private static final Context CONTEXT = WeHomeApplication.getInstance();

    public static UserDto loadUser() {
        String json = PreferenceUtil.getString(CONTEXT, PREFERENCE_NAME, USER);
        return StrUtils.fromJson(json, UserDto.class);
    }

    public static void saveUser(UserDto user) {
        PreferenceUtil.putString(CONTEXT, PREFERENCE_NAME, USER, StrUtils.toJson(user));
    }

    public static void clearUser(){
        PreferenceUtil.putString(CONTEXT, PREFERENCE_NAME, USER, "");
    }

    public static String getFamilyPhoto(){
        return PreferenceUtil.getString(CONTEXT,PREFERENCE_NAME,PHOTO);
    }

    public static void setFamilyPhoto(String path){
        PreferenceUtil.putString(CONTEXT, PREFERENCE_NAME, PHOTO, path);
    }


}
