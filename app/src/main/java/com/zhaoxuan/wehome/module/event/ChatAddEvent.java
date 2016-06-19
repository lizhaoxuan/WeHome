package com.zhaoxuan.wehome.module.event;

/**
 * Created by lizhaoxuan on 16/6/19.
 */
public class ChatAddEvent {

    private boolean isSuccess;

    private String msg;

    public ChatAddEvent(boolean isSuccess, String msg) {
        this.isSuccess = isSuccess;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
