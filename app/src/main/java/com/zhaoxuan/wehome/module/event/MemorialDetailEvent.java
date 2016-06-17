package com.zhaoxuan.wehome.module.event;

import com.zhaoxuan.wehome.support.dto.MemorialDto;

/**
 * Created by lizhaoxuan on 16/6/17.
 */
public class MemorialDetailEvent {
    public static final int ADD_MEMORIAL = 1;
    public static final int CHANGE_MEMORIAL = 2;
    public static final int DELETE_MEMORIAL = 3;


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

    public MemorialDetailEvent(boolean isSuccess, int kind, String msg) {
        this.isSuccess = isSuccess;
        this.kind = kind;
        this.msg = msg;
    }
}
