package com.zhaoxuan.wehome.support.dto;

import com.zhaoxuan.wehome.support.entity.WishEntity;

import java.io.Serializable;

/**
 * Created by lizhaoxuan on 15/11/27.
 */
public class WishDto extends WishEntity implements Serializable {

    public WishDto(String buildAccount, String buildName, String buildPost, int id, String imgUrl, boolean isFinish, String time, String title, String wishContent, WishEntity data) {
        super(buildAccount, buildName, buildPost, id, imgUrl, isFinish, time, title, wishContent);
    }

    public String getFinsih() {
        if (isFinish) {
            return "已完成";
        } else {
            return "未完成";
        }
    }

    public String getFullName(){
        return buildName+" | "+buildPost;
    }

}
