package com.zhaoxuan.wehome.support.dto;

import com.zhaoxuan.wehome.support.entity.UserEntity;

import java.io.Serializable;

/**
 * Created by lizhaoxuan on 15/11/13.
 */
public class UserDto extends UserEntity implements Serializable{
    public static final int KEY_NAME = 1;
    public static final int KEY_POST = 2;
    public static final int KEY_HOME_NAME = 3;
    public static final int KEY_HOME_ID = 4;
    public static final int KEY_ACCOUNT = 5;
    public static final int KEY_CITY = 6;
    public static final int KEY_PASSWORD = 7;


    public UserDto(String account, String city, String familyBuild, String headImageUri, String homeId, String homeName, int id, String name, String password, String post) {
        super(account, city, familyBuild, headImageUri, homeId, homeName, id, name, password, post);
    }

    public boolean isHaveHome() {
        return !homeId.equals("");
    }

    public void setValue(int key, String value) {
        switch (key) {
            case KEY_NAME:
                name = value;
                return;
            case KEY_POST:
                post = value;
                return;
            case KEY_HOME_NAME:
                homeName = value;
                return;
            case KEY_HOME_ID:
                homeId = value;
                return;
            case KEY_ACCOUNT:
                account = value;
                return;
            case KEY_CITY:
                city = value;
                return;
            case KEY_PASSWORD:
                password = value;
                return;
        }
    }

}
