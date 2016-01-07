package com.zhaoxuan.wehome.support.dto;

import com.zhaoxuan.wehome.support.entity.WZoneEntity;

/**
 * Created by lizhaoxuan on 16/1/7.
 */
public class WZoneDto extends WZoneEntity {

    public WZoneDto(String buildName, String buildPost, String familyAccount, String familyName, int id, String msg, String picUrl, int praise, String time) {
        super(buildName, buildPost, familyAccount, familyName, id, msg, picUrl, praise, time);
    }

    public String getFullName() {
        return buildName + " | " + buildPost;
    }
}
