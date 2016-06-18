package com.zhaoxuan.wehome.framework.model.impl;

import com.zhaoxuan.cakedao.AbstractCakeDao;
import com.zhaoxuan.cakedao.CakeDao;
import com.zhaoxuan.wehome.module.event.WZoneEvent;
import com.zhaoxuan.wehome.module.event.WishDetailEvent;
import com.zhaoxuan.wehome.support.constants.Ints;
import com.zhaoxuan.wehome.support.dispensebus.DispenseBus;
import com.zhaoxuan.wehome.support.dto.WZoneDto;
import com.zhaoxuan.wehome.support.utils.NetUtil;

/**
 * Created by lizhaoxuan on 16/6/18.
 */
public class WZoneModel {

    private DispenseBus dispenseBus = DispenseBus.getInstance();
    private AbstractCakeDao<WZoneDto> wzoneDao = CakeDao.getCakeDao(WZoneDto.class);

    public void getData() {
        if (NetUtil.isConnectingToInternet()) {
            WZoneDto[] dtos = wzoneDao.loadAllData();
            dispenseBus.post(new WZoneEvent(true, Ints.DATA_LOAD, "").setDtos(dtos));
        } else {
            dispenseBus.post(new WZoneEvent(false, Ints.DATA_LOAD, "网络请求失败，请稍后重试"));
        }
    }

    public void changeData(WZoneDto dto) {
        if (NetUtil.isConnectingToInternet()) {
            long result = wzoneDao.update(dto);
            if (result >= 0) {
                dispenseBus.post(new WZoneEvent(true, Ints.DATA_CHANGE, "成功评论"));
            } else {
                dispenseBus.post(new WZoneEvent(false, Ints.DATA_CHANGE, "评论失败"));
            }
        } else {
            dispenseBus.post(new WZoneEvent(false, Ints.DATA_CHANGE, "网络请求失败，请稍后重试"));
        }

    }

    public void addData(WZoneDto dto) {
        if (NetUtil.isConnectingToInternet()) {
            long result = wzoneDao.insert(dto);
            if (result >= 0) {
                dispenseBus.post(new WZoneEvent(true, Ints.DATA_ADD, "新建成功"));
            } else {
                dispenseBus.post(new WZoneEvent(false, Ints.DATA_ADD, "新建失败"));
            }
        } else {
            dispenseBus.post(new WZoneEvent(false, Ints.DATA_ADD, "网络请求失败，请稍后重试"));
        }

    }

}
