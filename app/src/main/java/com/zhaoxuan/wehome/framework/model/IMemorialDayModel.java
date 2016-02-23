package com.zhaoxuan.wehome.framework.model;

import android.util.SparseArray;

import com.zhaoxuan.wehome.support.dto.MemorialDayDto;

/**
 * Created by lizhaoxuan on 16/1/11.
 */
public interface IMemorialDayModel {

    void getData(ICallBack<SparseArray<MemorialDayDto>> callBack);

    void changeData(MemorialDayDto wishDto, ICallBack<SparseArray<MemorialDayDto>> callBack);

}
