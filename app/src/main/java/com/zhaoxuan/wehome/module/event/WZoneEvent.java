package com.zhaoxuan.wehome.module.event;

import com.zhaoxuan.wehome.support.dto.WZoneDto;

/**
 * Created by lizhaoxuan on 16/6/18.
 */
public class WZoneEvent {
    private int kind;
    private boolean isSuccess;
    private String msg = "";
    private WZoneDto[] dtos;

    public WZoneEvent(boolean isSuccess, int kind, String msg) {
        this.isSuccess = isSuccess;
        this.kind = kind;
        this.msg = msg;
    }

    public WZoneDto[] getDtos() {
        return dtos;
    }

    public WZoneEvent setDtos(WZoneDto[] dtos) {
        this.dtos = dtos;
        return this;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getKind() {
        return kind;
    }

    public String getMsg() {
        return msg;
    }
}
