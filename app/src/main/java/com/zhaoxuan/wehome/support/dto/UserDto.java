package com.zhaoxuan.wehome.support.dto;

import com.example.DataProperty;
import com.example.IdProperty;

import java.io.Serializable;

/**
 * Created by lizhaoxuan on 15/11/13.
 */
public class UserDto implements Serializable {
    public static final int KEY_NAME = 1;
    public static final int KEY_POST = 2;
    public static final int KEY_HOME_NAME = 3;
    public static final int KEY_HOME_ID = 4;
    public static final int KEY_ACCOUNT = 5;
    public static final int KEY_CITY = 6;
    public static final int KEY_PASSWORD = 7;

    @IdProperty
    protected long id;
    @DataProperty
    protected String account;
    @DataProperty
    protected String password;
    @DataProperty
    protected String name;
    @DataProperty
    protected String homeId;
    @DataProperty
    protected String homeName;
    @DataProperty
    protected String post;
    @DataProperty
    protected String headImageUri;
    @DataProperty
    protected String familyBuild;
    @DataProperty
    protected String city;

    public UserDto() {
    }

    public UserDto(String account, String city, String familyBuild, String headImageUri, String homeId, String homeName, int id, String name, String password, String post) {
        this.account = account;
        this.city = city;
        this.familyBuild = familyBuild;
        this.headImageUri = headImageUri;
        this.homeId = homeId;
        this.homeName = homeName;
        this.id = id;
        this.name = name;
        this.password = password;
        this.post = post;    }

    public String getFullName() {
        return name + " | " + post;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFamilyBuild() {
        return familyBuild;
    }

    public void setFamilyBuild(String familyBuild) {
        this.familyBuild = familyBuild;
    }

    public String getHeadImageUri() {
        return headImageUri;
    }

    public void setHeadImageUri(String headImageUri) {
        this.headImageUri = headImageUri;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

}
