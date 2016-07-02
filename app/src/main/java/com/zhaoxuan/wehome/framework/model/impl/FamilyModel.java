package com.zhaoxuan.wehome.framework.model.impl;

import com.zhaoxuan.cakedao.AbstractCakeDao;
import com.zhaoxuan.cakedao.CakeDao;
import com.zhaoxuan.wehome.framework.model.IFamilyModel;
import com.zhaoxuan.wehome.module.event.FamilyEvent;
import com.zhaoxuan.wehome.module.manager.FamilyManager;
import com.zhaoxuan.wehome.module.manager.UserManager;
import com.zhaoxuan.wehome.support.dispensebus.DispenseBus;
import com.zhaoxuan.wehome.support.dto.FamilyDto;
import com.zhaoxuan.wehome.support.dto.UserDto;
import com.zhaoxuan.wehome.support.utils.NetUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by lizhaoxuan on 16/2/23.
 */
public class FamilyModel implements IFamilyModel {
    private DispenseBus dispenseBus = DispenseBus.getInstance();
    private AbstractCakeDao<FamilyDto> familyDao = CakeDao.getCakeDao(FamilyDto.class);


    @Override
    public void getData() {
        if (NetUtil.isConnectingToInternet()) {
            List<FamilyDto> familyDtoList = new ArrayList<>();
            FamilyDto[] familyDtos = FamilyManager.getInstance().getFamilys();
            Collections.addAll(familyDtoList, familyDtos);
            dispenseBus.post(new FamilyEvent(true, familyDtoList,""));
        } else {
            dispenseBus.post(new FamilyEvent(false, null, "暂无网络，请稍后重试"));
        }
    }
}
