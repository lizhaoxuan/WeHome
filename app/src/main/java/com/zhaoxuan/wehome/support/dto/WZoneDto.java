package com.zhaoxuan.wehome.support.dto;

import com.zhaoxuan.wehome.support.entity.WZoneEntity;

/**
 * Created by lizhaoxuan on 16/1/7.
 */
public class WZoneDto extends WZoneEntity {

    private String[] praiseArray;
    private String[] picArray;

    public WZoneDto(String buildName, String buildPost, String familyAccount, String familyName, int id, String msg, String picUrlList, String praiseList, String time) {
        super(buildName, buildPost, familyAccount, familyName, id, msg, picUrlList, praiseList, time);
        picArray = picUrlList.split(",");
        praiseArray = praiseList.split(",");
    }

    public WZoneDto(WZoneEntity entity) {
        super(entity.getBuildName(),
                entity.getBuildPost(),
                entity.getFamilyAccount(),
                entity.getFamilyName(),
                entity.getId(),
                entity.getMsg(),
                entity.getPicUrlList(),
                entity.getPraiseList(),
                entity.getTime());
    }

    public String getFullName() {
        return buildName + " | " + buildPost;
    }

    public String[] getPicArray() {
        return picArray;
    }

    public String[] getPraiseArray() {
        return praiseArray;
    }

    public boolean hasPic() {
        return picArray.length == 0;
    }

    public int getpPraiseNum() {
        return picArray.length;
    }


}
