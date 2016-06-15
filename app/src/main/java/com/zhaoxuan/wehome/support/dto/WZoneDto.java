package com.zhaoxuan.wehome.support.dto;

import com.example.DataProperty;
import com.example.IdProperty;

import java.io.Serializable;

/**
 * Created by lizhaoxuan on 16/1/7.
 */
public class WZoneDto implements Serializable {

    @IdProperty
    protected long id;
    @DataProperty
    protected String familyAccount;
    @DataProperty
    protected String familyName;
    @DataProperty
    protected String buildName;
    @DataProperty
    protected String buildPost;
    @DataProperty
    protected String msg;
    @DataProperty
    protected String praiseList;
    @DataProperty
    protected String time;
    @DataProperty
    protected String picUrlList;

    private String[] praiseArray;
    private String[] picArray;

    public WZoneDto() {
    }

    public WZoneDto(String buildName, String buildPost, String familyAccount, String familyName, int id, String msg, String picUrlList, String praiseList, String time) {
        this.buildName = buildName;
        this.buildPost = buildPost;
        this.familyAccount = familyAccount;
        this.familyName = familyName;
        this.id = id;
        this.msg = msg;
        this.picUrlList = picUrlList;
        this.praiseList = praiseList;
        this.time = time;
        picArray = picUrlList.split(",");
        praiseArray = praiseList.split(",");
    }

    public String getFullName() {
        return buildName + " | " + buildPost;
    }

    public String[] getPicArray() {
        return picArray;
    }

    public String[] getPraiseArray() {
        return praiseArray;
    }

    public boolean hasPic() {
        return picArray.length == 0;
    }

    public int getpPraiseNum() {
        return picArray.length;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
