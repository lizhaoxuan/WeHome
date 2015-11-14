package com.zhaoxuan.wehome.support.dto;

/**
 * Created by lizhaoxuan on 15/11/13.
 */
public class UserDto {

    private String account;
    private String password;
    private String name;
    private String familyAccount;
    private String familyName;
    private String post;
    private boolean haveHome;
    private String headImageUri;
    private String familyBuild;

    public UserDto() {
    }

    public UserDto(String account, String password, String name, String familyAccount, String familyName, String post, boolean haveHome, String headImageUri, String familyBuild) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.familyAccount = familyAccount;
        this.familyName = familyName;
        this.post = post;
        this.haveHome = haveHome;
        this.headImageUri = headImageUri;
        this.familyBuild = familyBuild;
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

    public String getFamilyAccount() {
        return familyAccount;
    }

    public void setFamilyAccount(String familyAccount) {
        this.familyAccount = familyAccount;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public boolean isHaveHome() {
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
}
