package com.zhaoxuan.wehome.module.event;

/**
 * Created by lizhaoxuan on 16/6/19.
 */
public class NotificationEvent {

    private String title;

    private String des;

    public NotificationEvent(String des, String title) {
        this.des = des;
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public String getTitle() {
        return title;
    }
}
