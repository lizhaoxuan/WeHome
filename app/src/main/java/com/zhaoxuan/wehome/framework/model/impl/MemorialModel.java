package com.zhaoxuan.wehome.framework.model.impl;

import android.util.SparseArray;

import com.zhaoxuan.cakedao.AbstractCakeDao;
import com.zhaoxuan.cakedao.CakeDao;
import com.zhaoxuan.wehome.framework.model.ICallBack;
import com.zhaoxuan.wehome.framework.model.IMemorialModel;
import com.zhaoxuan.wehome.module.event.MemorialEvent;
import com.zhaoxuan.wehome.support.dispensebus.DispenseBus;
import com.zhaoxuan.wehome.support.dto.MemorialDto;
import com.zhaoxuan.wehome.support.utils.DateUtil;
import com.zhaoxuan.wehome.support.utils.NetUtil;

import java.util.Date;

/**
 * Created by lizhaoxuan on 16/1/11.
 */
public class MemorialModel implements IMemorialModel {
    private DispenseBus dispenseBus = DispenseBus.getInstance();
    private AbstractCakeDao<MemorialDto> memorialDao = CakeDao.getCakeDao(MemorialDto.class);

    /**
     * ------  IMemorialModel  ------
     **/
    @Override
    public void getData() {
        SparseArray<MemorialDto> dtos = new SparseArray<>();
        if (NetUtil.isConnectingToInternet()) {
            MemorialDto[] memorialDayDtos = memorialDao.loadAllData();
            if (memorialDayDtos != null) {
                for (int i = 0, l = memorialDayDtos.length; i < l; i++) {
                    dtos.append(i,memorialDayDtos[i]);
                }
            } else {
                dtos.append(0,new MemorialDto("0","wehome", DateUtil.getDefaultDate(new Date()),false,"我们的家建立"));
                dtos.append(1,new MemorialDto("0","wehome",DateUtil.getDefaultDate(new Date()),false,"微家创建"));
            }
            dispenseBus.post(new MemorialEvent(true,dtos));
        }else {
            dispenseBus.post(new MemorialEvent(false,dtos,"暂无网络，请稍后重试"));
        }
    }


    /**
     * ------  IMemorialDayDetailModel ------
     **/
    @Override
    public void changeData(MemorialDto wishDto, ICallBack<SparseArray<MemorialDto>> callBack) {

    }


}
