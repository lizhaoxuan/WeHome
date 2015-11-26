package com.zhaoxuan.wehome.support.dto;

/**
 * Created by lizhaoxuan on 15/11/13.
 */
public class UserDto {
    public static final int KEY_NAME = 1;
    public static final int KEY_POST = 2;
    public static final int KEY_HOME_NAME = 3;
    public static final int KEY_HOME_ID = 4;
    public static final int KEY_ACCOUNT = 5;
    public static final int KEY_CITY = 6;

    private String account;
    private String password;
    private String name;
    private String homeId;
    private String homeName;
    private String post;
    private boolean haveHome;
    private String headImageUri;
    private String headImagePath;
    private String familyBuild;
    private String city;
    public UserDto() {
    }

    public UserDto(String account, String password, String name, String homeId, String homeName, String post, boolean haveHome, String headImageUri, String familyBuild, String headImagePath,String city) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.homeId = homeId;
        this.homeName = homeName;
        this.post = post;
        this.haveHome = haveHome;
        this.headImageUri = headImageUri;
        this.familyBuild = familyBuild;
        this.headImagePath = headImagePath;
        this.city = city;
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
                return;
            case KEY_HOME_ID:
                return;
            case KEY_ACCOUNT:
                return;
            case KEY_CITY:
                return;
        }
    }

}
