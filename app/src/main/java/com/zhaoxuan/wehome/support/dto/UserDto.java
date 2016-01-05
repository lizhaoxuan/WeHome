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


    public UserDto(String account, String city, String familyBuild, boolean haveHome, String headImagePath, String headImageUri, String homeId, String homeName, String name, String password, String post) {
        super(account, city, familyBuild, haveHome, headImagePath, headImageUri, homeId, homeName, name, password, post);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomeId() {
        return homeId;
    }

    public void setHomeId(String homeId) {
        this.homeId = homeId;
    }

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public boolean isHaveHome() {
        haveHome = !homeId.equals("");
        return haveHome;
    }

    public void setHaveHome(boolean haveHome) {
        this.haveHome = haveHome;
    }

    public String getHeadImageUri() {
        return headImageUri;
    }

    public void setHeadImageUri(String headImageUri) {
        this.headImageUri = headImageUri;
    }

    public String getFamilyBuild() {
        return familyBuild;
    }

    public void setFamilyBuild(String familyBuild) {
        this.familyBuild = familyBuild;
    }

    public String getHeadImagePath() {
        return headImagePath;
    }

    public void setHeadImagePath(String headImagePath) {
        this.headImagePath = headImagePath;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
