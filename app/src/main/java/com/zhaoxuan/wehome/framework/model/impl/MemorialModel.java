package com.zhaoxuan.wehome.framework.model.impl;

import android.util.SparseArray;

import com.zhaoxuan.cakedao.AbstractCakeDao;
import com.zhaoxuan.cakedao.CakeDao;
import com.zhaoxuan.wehome.framework.model.IMemorialModel;
import com.zhaoxuan.wehome.module.event.MemorialDetailEvent;
import com.zhaoxuan.wehome.module.event.MemorialEvent;
import com.zhaoxuan.wehome.support.constants.Ints;
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
                    dtos.append(i, memorialDayDtos[i]);
                }
            } else {
                MemorialDto m1 = new MemorialDto("0", "wehome", DateUtil.getDefaultDate(new Date()), false, "我们的家建立");
                MemorialDto m2 = new MemorialDto("0", "wehome", DateUtil.getDefaultDate(new Date()), false, "微家创建");
                dtos.append(0, m1);
                dtos.append(1, m2);
                memorialDao.insert(m1);
                memorialDao.insert(m2);
            }
            dispenseBus.post(new MemorialEvent(true, dtos));
        } else {
            dispenseBus.post(new MemorialEvent(false, dtos, "暂无网络，请稍后重试"));
        }
    }

    /**
     * ------  IMemorialDayDetailModel ------
     **/

    @Override
    public void addData(MemorialDto dto) {
        if (NetUtil.isConnectingToInternet()) {
            long result = memorialDao.insert(dto);
            if (result >= 0) {
                dispenseBus.post(new MemorialDetailEvent(true, Ints.DATA_ADD, "新建纪念日成功"));
            } else {
                dispenseBus.post(new MemorialDetailEvent(false, Ints.DATA_ADD, "新建纪念日失败"));
            }
        } else {
            dispenseBus.post(new MemorialDetailEvent(false, Ints.DATA_ADD, "网络请求失败，请稍后重试"));
        }
    }

    @Override
    public void changeData(MemorialDto dto) {
        if (NetUtil.isConnectingToInternet()) {
            long result = memorialDao.update(dto);
            if (result >= 0) {
                dispenseBus.post(new MemorialDetailEvent(true, Ints.DATA_CHANGE, "修改纪念日成功"));
            } else {
                dispenseBus.post(new MemorialDetailEvent(false, Ints.DATA_CHANGE, "修改纪念日失败，纪念日可能不存在"));
            }
        } else {
            dispenseBus.post(new MemorialDetailEvent(false, Ints.DATA_CHANGE, "网络请求失败，请稍后重试"));
        }
    }

    @Override
    public void deleteData(long id) {
        if (NetUtil.isConnectingToInternet()) {
            long result = memorialDao.deleteById(id);
            if (result >= 0) {
                dispenseBus.post(new MemorialDetailEvent(true, Ints.DATA_DELETE, "删除纪念日成功"));
            } else {
                dispenseBus.post(new MemorialDetailEvent(false, Ints.DATA_DELETE, "删除纪念日失败，纪念日可能不存在"));
            }
        } else {
            dispenseBus.post(new MemorialDetailEvent(false, Ints.DATA_DELETE, "网络请求失败，请稍后重试"));
        }
    }


}
