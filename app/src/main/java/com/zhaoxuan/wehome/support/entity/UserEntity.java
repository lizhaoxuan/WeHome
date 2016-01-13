package com.zhaoxuan.wehome.support.entity;

/**
 * Created by lizhaoxuan on 16/1/5.
 */
public class UserEntity {

    protected int id;
    protected String account;
    protected String password;
    protected String name;
    protected String homeId;
    protected String homeName;
    protected String post;
    protected String headImageUri;
    protected String familyBuild;
    protected String city;

    public UserEntity(String account, String city, String familyBuild, String headImageUri, String homeId, String homeName, int id, String name, String password, String post) {
        this.account = account;
        this.city = city;
        this.familyBuild = familyBuild;
        this.headImageUri = headImageUri;
        this.homeId = homeId;
        this.homeName = homeName;
        this.id = id;
        this.name = name;
        this.password = password;
        this.post = post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
