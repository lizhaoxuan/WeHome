package com.zhaoxuan.wehome.framework.model.impl;

import com.zhaoxuan.wehome.framework.model.ICallBack;
import com.zhaoxuan.wehome.framework.model.IMemorialDayDetailModel;
import com.zhaoxuan.wehome.framework.model.IMemorialDayModel;
import com.zhaoxuan.wehome.support.dto.MemorialDayDto;

/**
 * Created by lizhaoxuan on 16/1/11.
 */
public class MemorialDayModel implements IMemorialDayModel, IMemorialDayDetailModel {


    /*  IMemorialDayModel  */
    @Override
    public void getData(ICallBack callBack) {

    }


    /*  IMemorialDayDetailModel */
    @Override
    public void changeData(MemorialDayDto wishDto, ICallBack callBack) {

    }


}
