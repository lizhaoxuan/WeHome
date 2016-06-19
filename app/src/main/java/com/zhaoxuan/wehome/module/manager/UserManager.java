package com.zhaoxuan.wehome.module.manager;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import com.zhaoxuan.cakedao.AbstractCakeDao;
import com.zhaoxuan.cakedao.CakeDao;
import com.zhaoxuan.wehome.support.dto.UserDto;

/**
 * Created by lizhaoxuan on 16/6/14.
 */
public class UserManager {
    private static final String TAG = UserManager.class.getSimpleName();

    private static volatile UserManager instance;

    public static UserManager getInstance() {
        if (instance == null) {
            synchronized (UserManager.class) {
                if (instance == null) {
                    instance = new UserManager();
                }
            }
        }
        return instance;
    }

    private UserManager() {
        if (CakeDao.instance.classMap == null) {
            Log.d("TAG", "CakeDao.instance.classMap == null");
        } else {
            userDao = CakeDao.getCakeDao(UserDto.class);
        }
    }

    private UserDto userDto = null;
    private AbstractCakeDao<UserDto> userDao;
    private int electricLevel;


    public static void electricMoniter(Context context) {
        BatteryInfoBroadcastReceiver receiver = new BatteryInfoBroadcastReceiver();
        IntentFilter filter = new IntentFilter(
                Intent.ACTION_BATTERY_CHANGED);
        context.registerReceiver(receiver, filter);
    }

    public static void unRegisterElectricMoniter(Context context) {
        BatteryInfoBroadcastReceiver receiver = new BatteryInfoBroadcastReceiver();
        context.unregisterReceiver(receiver);
    }

    public UserDto getUserDto() {
        if (userDto == null) {
            userDto = SharedManager.loadUser();
            return userDto;
        } else {
            return userDto;
        }
    }

    public void setUserDto(UserDto userDto) {
        if (userDto == null) {
            return;
        }
        this.userDto = userDto;
        SharedManager.saveUser(userDto);
    }

    public void setUserValue(int key, String value) {
        switch (key) {
            case UserDto.KEY_NAME:
                userDto.setName(value);
                break;
            case UserDto.KEY_POST:
                userDto.setPost(value);
                break;
            case UserDto.KEY_HOME_NAME:
                userDto.setHomeName(value);
                break;
            case UserDto.KEY_HOME_ID:
                userDto.setHomeId(value);
                break;
            case UserDto.KEY_ACCOUNT:
                userDto.setAccount(value);
                break;
            case UserDto.KEY_CITY:
                userDto.setCity(value);
                break;
            case UserDto.KEY_PASSWORD:
                userDto.setPassword(value);
                break;
            case UserDto.KEY_HEAD_IMAGE_URI:
                userDto.setHeadImageUri(value);
                break;
        }
        SharedManager.saveUser(userDto);
        userDao.update(userDto);
    }

    public void clearSharedForUser() {
        userDao = null;
        SharedManager.clearUser();
    }

    public int getElectricLevel() {
        return electricLevel;
    }

    public void setElectricLevel(int electricLevel) {
        this.electricLevel = electricLevel;
    }
}
