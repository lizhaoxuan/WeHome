package com.zhaoxuan.wehome.support.entity;

/**
 * Created by lizhaoxuan on 16/1/7.
 */
public class MemorialDayEntity {

    protected int id;
    protected String title;
    protected String datetime;
    protected String buildName;
    protected String buildAccount;
    protected boolean loop;


    public MemorialDayEntity(String buildAccount, String buildName, String datetime, int id, boolean loop, String title) {
        this.buildAccount = buildAccount;
        this.buildName = buildName;
        this.datetime = datetime;
        this.id = id;
        this.loop = loop;
        this.title = title;
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

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
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

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
