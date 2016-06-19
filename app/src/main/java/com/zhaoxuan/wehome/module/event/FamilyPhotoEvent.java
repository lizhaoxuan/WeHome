package com.zhaoxuan.wehome.module.event;

/**
 * Created by lizhaoxuan on 16/6/19.
 */
public class FamilyPhotoEvent {

    private boolean isSuccess;

    private String path;

    private String msg;

    public FamilyPhotoEvent(boolean isSuccess, String msg, String path) {
        this.isSuccess = isSuccess;
        this.msg = msg;
        this.path = path;
    }

    public String getMsg() {
        return msg;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getPath() {
        return path;
    }
}
