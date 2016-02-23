package com.zhaoxuan.wehome.support.dto;

import com.zhaoxuan.wehome.support.entity.FamilyEntity;

/**
 * Created by lizhaoxuan on 16/1/7.
 */
public class FamilyDto extends FamilyEntity {

    private String weather;

    public FamilyDto(String account, String city, int electric, String headPath, String headUrl, int id, String name, String post) {
        super(account, city, electric, headPath, headUrl, id, name, post);
    }

    public String getFullName() {
        return name + " | " + post;
    }

}
