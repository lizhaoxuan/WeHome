package com.zhaoxuan.wehome.module.event;

import android.util.SparseArray;

import com.zhaoxuan.wehome.support.dto.MemorialDto;

/**
 * Created by lizhaoxuan on 16/6/17.
 */
public class MemorialEvent {

    private boolean isSuccess;

    private SparseArray<MemorialDto> dtos;

    private String error;

    public MemorialEvent(boolean isSuccess, SparseArray<MemorialDto> dtos) {
        this.dtos = dtos;
        this.isSuccess = isSuccess;
    }

    public MemorialEvent(boolean isSuccess, SparseArray<MemorialDto> dtos, String error) {
        this.dtos = dtos;
        this.error = error;
        this.isSuccess = isSuccess;
    }

    public SparseArray<MemorialDto> getDtos() {
        return dtos;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getError() {
        return error;
    }
}
