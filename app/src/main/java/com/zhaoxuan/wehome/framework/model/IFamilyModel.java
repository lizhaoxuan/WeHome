package com.zhaoxuan.wehome.framework.model;

import com.zhaoxuan.wehome.support.dto.FamilyDto;

import java.util.List;

/**
 * Created by lizhaoxuan on 16/2/23.
 */
public interface IFamilyModel {

    void getData(ICallBack<List<FamilyDto>> callBack);

}
