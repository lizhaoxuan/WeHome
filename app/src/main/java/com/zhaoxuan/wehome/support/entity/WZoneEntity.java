package com.zhaoxuan.wehome.support.entity;

import java.util.List;

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
    protected int praise;
    protected String time;
    protected String picUrl;

    public WZoneEntity(String buildName, String buildPost, String familyAccount, String familyName, int id, String msg, String picUrl, int praise, String time) {
        this.buildName = buildName;
        this.buildPost = buildPost;
        this.familyAccount = familyAccount;
        this.familyName = familyName;
        this.id = id;
        this.msg = msg;
        this.picUrl = picUrl;
        this.praise = praise;
        this.time = time;
    }
}
