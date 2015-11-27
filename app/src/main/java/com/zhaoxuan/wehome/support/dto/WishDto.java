package com.zhaoxuan.wehome.support.dto;

/**
 * Created by lizhaoxuan on 15/11/27.
 */
public class WishDto {

    private int id;
    private String title;
    private String time;
    private String wishContent;
    private String buildName;
    private String buildPost;
    private String buildAccount;
    private String imgPath;
    private String imgUrl;
    private boolean isFinish;

    public WishDto() {
    }

    public WishDto(int id, String title, String time, String wishContent, String buildName, String buildPost, String buildAccount, String imgPath, String imgUrl, boolean isFinish) {
        this.id = id;
        this.title = title;
        this.time = time;
        this.wishContent = wishContent;
        this.buildName = buildName;
        this.buildPost = buildPost;
        this.buildAccount = buildAccount;
        this.imgPath = imgPath;
        this.imgUrl = imgUrl;
        this.isFinish = isFinish;
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
}
