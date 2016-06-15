package com.zhaoxuan.wehome.support.dto;

import com.example.DataProperty;
import com.example.IdProperty;

import java.io.Serializable;

/**
 * Created by lizhaoxuan on 15/11/27.
 */
public class WishDto implements Serializable {

    @IdProperty
    protected long id;
    @DataProperty
    protected String title;
    @DataProperty
    protected String time;
    @DataProperty
    protected String wishContent;
    @DataProperty
    protected String buildName;
    @DataProperty
    protected String buildPost;
    @DataProperty
    protected String buildAccount;
    @DataProperty
    protected String imgUrl;
    @DataProperty
    protected boolean isFinish;

    public WishDto() {
    }

    public WishDto(String buildAccount, String buildName, String buildPost, int id, String imgUrl, boolean isFinish, String time, String title, String wishContent) {
        this.buildAccount = buildAccount;
        this.buildName = buildName;
        this.buildPost = buildPost;
        this.id = id;
        this.imgUrl = imgUrl;
        this.isFinish = isFinish;
        this.time = time;
        this.title = title;
        this.wishContent = wishContent;
    }

    public String getFinsih() {
        if (isFinish) {
            return "已完成";
        } else {
            return "未完成";
        }
    }

    public String getFullName() {
        return buildName + " | " + buildPost;
    }

    public String getBuildAccount() {
        return buildAccount;
    }

    public void setBuildAccount(String buildAccount) {
        this.buildAccount = buildAccount;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public boolean isFinish() {
        return isFinish;
    }

    public void setIsFinish(boolean isFinish) {
        this.isFinish = isFinish;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWishContent() {
        return wishContent;
    }

    public void setWishContent(String wishContent) {
        this.wishContent = wishContent;
    }
}
