package com.zhaoxuan.wehome.framework.model;

import android.util.SparseArray;

import com.zhaoxuan.wehome.support.dto.FamilyDto;
import com.zhaoxuan.wehome.support.dto.MemorialDayDto;

import java.util.List;

/**
 * Created by lizhaoxuan on 16/2/23.
 */
public interface IFamilyModel {

    void getData(ICallBack<List<FamilyDto>> callBack);

}
