package com.zhaoxuan.wehome.module.event;

import com.zhaoxuan.wehome.support.dto.FamilyDto;

import java.util.List;

/**
 * Created by lizhaoxuan on 16/6/18.
 */
public class FamilyEvent {

    private boolean isSuccess;
    private String msg;
    private List<FamilyDto> familyDtos;

    public FamilyEvent(boolean isSuccess, List<FamilyDto> familyDtos, String msg) {
        this.familyDtos = familyDtos;
        this.isSuccess = isSuccess;
        this.msg = msg;
    }


    public List<FamilyDto> getFamilyDtos() {
        return familyDtos;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getMsg() {
        return msg;
    }


}
