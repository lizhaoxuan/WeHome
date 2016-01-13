package com.zhaoxuan.wehome.support.entity;

/**
 * Created by lizhaoxuan on 16/1/7.
 */
public class WZoneEntity {

    protected int id;
    protected String familyAccount;
    protected String familyName;
    protected String buildName;
    protected String buildPost;
    protected String msg;
    protected String praiseList;
    protected String time;
    protected String picUrlList;

    public WZoneEntity(String buildName, String buildPost, String familyAccount, String familyName, int id, String msg, String picUrlList, String praiseList, String time) {
        this.buildName = buildName;
        this.buildPost = buildPost;
        this.familyAccount = familyAccount;
        this.familyName = familyName;
        this.id = id;
        this.msg = msg;
        this.picUrlList = picUrlList;
        this.praiseList = praiseList;
        this.time = time;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public String getBuildPost() {
        return buildPost;
    }

    public void setBuildPost(String buildPost) {
        this.buildPost = buildPost;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getPicUrlList() {
        return picUrlList;
    }

    public void setPicUrlList(String picUrlList) {
        this.picUrlList = picUrlList;
    }

    public String getPraiseList() {
        return praiseList;
    }

    public void setPraiseList(String praiseList) {
        this.praiseList = praiseList;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
