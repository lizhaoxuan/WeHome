package com.zhaoxuan.wehome.support.dto;

import com.example.DataProperty;
import com.example.IdProperty;

import java.io.Serializable;

/**
 * Created by lizhaoxuan on 16/6/19.
 */
public class ChatDto implements Serializable {

    @IdProperty
    protected long id;

    @DataProperty
    protected String content = "";

    @DataProperty
    protected String headPath = "";

    @DataProperty
    protected String picPath = "";

    @DataProperty
    protected String time = "";

    @DataProperty
    protected String buildOf = "";

    @DataProperty
    protected String buildAccount = "";

    public ChatDto() {
    }

    public ChatDto(String buildAccount, String buildOf, String content, String picPath, String time, String headPath) {
        this.buildAccount = buildAccount;
        this.buildOf = buildOf;
        this.content = content;
        this.picPath = picPath;
        this.time = time;
        this.headPath = headPath;
    }

    public String getHeadPath() {
        return headPath;
    }

    public void setHeadPath(String headPath) {
        this.headPath = headPath;
    }

    public String getBuildAccount() {
        return buildAccount;
    }

    public void setBuildAccount(String buildAccount) {
        this.buildAccount = buildAccount;
    }

    public String getBuildOf() {
        return buildOf;
    }

    public void setBuildOf(String buildOf) {
        this.buildOf = buildOf;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
