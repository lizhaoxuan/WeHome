package com.zhaoxuan.wehome.support.dto;

import com.zhaoxuan.wehome.support.entity.WishEntity;

import java.io.Serializable;

/**
 * Created by lizhaoxuan on 15/11/27.
 */
public class WishDto extends WishEntity implements Serializable {

    public WishDto(String buildAccount, String buildName, String buildPost, int id, String imgPath, String imgUrl, boolean isFinish, String time, String title, String wishContent, WishEntity data) {
        super(buildAccount, buildName, buildPost, id, imgPath, imgUrl, isFinish, time, title, wishContent);
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWishContent() {
        return wishContent;
    }

    public void setWishContent(String wishContent) {
        this.wishContent = wishContent;
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

    public String getBuildAccount() {
        return buildAccount;
    }

    public void setBuildAccount(String buildAccount) {
        this.buildAccount = buildAccount;
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

    public String getFinsih() {
        if (isFinish) {
            return "已完成";
        } else {
            return "未完成";
        }
    }

    public String getBuildOf(){
        return buildName+" | "+buildPost;
    }

}
