package com.zhaoxuan.wehome.module.event;

/**
 * Created by lizhaoxuan on 16/6/17.
 */
public class WishDetailEvent {

    public static final int ADD_WISH = 1;
    public static final int CHANGE_WISH = 2;
    public static final int DELETE_WISH = 3;


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
