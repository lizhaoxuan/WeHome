package com.zhaoxuan.wehome.support.entity;

/**
 * Created by lizhaoxuan on 16/1/5.
 */
public class WishEntity {

    protected int id;
    protected String title;
    protected String time;
    protected String wishContent;
    protected String buildName;
    protected String buildPost;
    protected String buildAccount;
    protected String imgUrl;
    protected boolean isFinish;

    public WishEntity(String buildAccount, String buildName, String buildPost, int id, String imgUrl, boolean isFinish, String time, String title, String wishContent) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
