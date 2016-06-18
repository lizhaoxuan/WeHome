package com.zhaoxuan.wehome.module.event;

/**
 * Created by lizhaoxuan on 16/6/17.
 */
public class WishDetailEvent {

    private int kind;
    private boolean isSuccess;
    private String msg;

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getKind() {
        return kind;
    }


    public String getMsg() {
        return msg;
    }

    public WishDetailEvent(boolean isSuccess, int kind, String msg) {
        this.isSuccess = isSuccess;
        this.kind = kind;
        this.msg = msg;
    }

}
