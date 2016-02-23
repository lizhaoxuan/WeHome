package com.zhaoxuan.wehome.framework.model.impl;

import android.util.SparseArray;

import com.zhaoxuan.wehome.framework.model.ICallBack;
import com.zhaoxuan.wehome.framework.model.IMemorialDayModel;
import com.zhaoxuan.wehome.support.dto.MemorialDayDto;

/**
 * Created by lizhaoxuan on 16/1/11.
 */
public class MemorialDayModel implements IMemorialDayModel {


    /*  IMemorialDayModel  */
    @Override
    public void getData(ICallBack<SparseArray<MemorialDayDto>> callBack) {

    }


    /*  IMemorialDayDetailModel */
    @Override
    public void changeData(MemorialDayDto wishDto, ICallBack<SparseArray<MemorialDayDto>> callBack) {

    }


}
