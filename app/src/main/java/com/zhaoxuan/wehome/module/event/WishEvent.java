package com.zhaoxuan.wehome.module.event;

import com.zhaoxuan.wehome.support.dto.MemorialDto;
import com.zhaoxuan.wehome.support.dto.WishDto;

/**
 * Created by lizhaoxuan on 16/6/17.
 */
public class WishEvent {

    private boolean isSuccess;

    private WishDto[] dtos;

    private String error;

    public WishEvent(boolean isSuccess, WishDto[] dtos, String error) {
        this.dtos = dtos;
        this.error = error;
        this.isSuccess = isSuccess;
    }

    public WishDto[] getDtos() {
        return dtos;
    }

    public String getError() {
        return error;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
}
