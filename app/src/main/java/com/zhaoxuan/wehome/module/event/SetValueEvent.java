package com.zhaoxuan.wehome.module.event;

/**
 * Created by lizhaoxuan on 16/6/16.
 */
public class SetValueEvent {

    private boolean isSuccess;

    private String msg;

    public SetValueEvent(boolean isSuccess, String msg) {
        this.isSuccess = isSuccess;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getMsg() {
        return msg;
    }
}
