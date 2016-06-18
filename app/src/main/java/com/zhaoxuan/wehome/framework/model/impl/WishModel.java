package com.zhaoxuan.wehome.framework.model.impl;

import com.zhaoxuan.cakedao.AbstractCakeDao;
import com.zhaoxuan.cakedao.CakeDao;
import com.zhaoxuan.wehome.module.event.WishDetailEvent;
import com.zhaoxuan.wehome.module.event.WishEvent;
import com.zhaoxuan.wehome.support.dispensebus.DispenseBus;
import com.zhaoxuan.wehome.support.dto.WishDto;
import com.zhaoxuan.wehome.support.utils.NetUtil;

/**
 * Created by lizhaoxuan on 15/11/27.
 */
public class WishModel {
    private DispenseBus dispenseBus = DispenseBus.getInstance();
    private AbstractCakeDao<WishDto> wishDao = CakeDao.getCakeDao(WishDto.class);

    public void getData() {
        if (NetUtil.isConnectingToInternet()) {
            WishDto[] wishDtos = wishDao.loadAllData();
            dispenseBus.post(new WishEvent(true,wishDtos,""));
        }else {
            dispenseBus.post(new WishEvent(false,null,"网络请求失败，请稍后重试"));
        }
    }

    public void addData(WishDto dto) {
        if (NetUtil.isConnectingToInternet()) {
            long result = wishDao.insert(dto);
            if (result >= 0) {
                dispenseBus.post(new WishDetailEvent(true, WishDetailEvent.ADD_WISH, "添加计划成功"));
            } else {
                dispenseBus.post(new WishDetailEvent(false, WishDetailEvent.ADD_WISH, "添加计划失败"));
            }
        } else {
            dispenseBus.post(new WishDetailEvent(false, WishDetailEvent.ADD_WISH, "网络请求失败，请稍后重试"));
        }
    }

    public void changeData(WishDto dto) {
        if (NetUtil.isConnectingToInternet()) {
            long result = wishDao.update(dto);
            if (result >= 0) {
                dispenseBus.post(new WishDetailEvent(true, WishDetailEvent.CHANGE_WISH, "修改计划成功"));
            } else {
                dispenseBus.post(new WishDetailEvent(false, WishDetailEvent.CHANGE_WISH, "修改计划失败"));
            }
        } else {
            dispenseBus.post(new WishDetailEvent(false, WishDetailEvent.CHANGE_WISH, "网络请求失败，请稍后重试"));
        }
    }

    public void deleteData(WishDto dto) {
        if (NetUtil.isConnectingToInternet()) {
            long result = wishDao.deleteById(dto);
            if (result >= 0) {
                dispenseBus.post(new WishDetailEvent(true, WishDetailEvent.DELETE_WISH, "删除计划成功"));
            } else {
                dispenseBus.post(new WishDetailEvent(false, WishDetailEvent.DELETE_WISH, "删除计划失败"));
            }
        } else {
            dispenseBus.post(new WishDetailEvent(false, WishDetailEvent.DELETE_WISH, "网络请求失败，请稍后重试"));
        }
    }
}
