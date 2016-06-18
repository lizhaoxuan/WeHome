package com.zhaoxuan.wehome.framework.model.impl;

import com.zhaoxuan.cakedao.AbstractCakeDao;
import com.zhaoxuan.cakedao.CakeDao;
import com.zhaoxuan.wehome.framework.model.IFamilyModel;
import com.zhaoxuan.wehome.module.event.FamilyEvent;
import com.zhaoxuan.wehome.module.manager.UserManager;
import com.zhaoxuan.wehome.support.dispensebus.DispenseBus;
import com.zhaoxuan.wehome.support.dto.FamilyDto;
import com.zhaoxuan.wehome.support.dto.UserDto;
import com.zhaoxuan.wehome.support.utils.NetUtil;

import java.util.ArrayList;
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
            UserDto userDto = UserManager.getInstance().getUserDto();
            List<FamilyDto> familyDtoList = new ArrayList<>();
            FamilyDto[] familyDtos = familyDao.loadAllData();
            if (familyDtos != null && familyDtos.length != 0) {
                for (FamilyDto dto : familyDtos) {
                    if (dto.getAccount().equals(userDto.getAccount())){
                        dto.setElectric(UserManager.getInstance().getElectricLevel());
                    }
                    familyDtoList.add(dto);
                }
            } else {
                FamilyDto f1 = new FamilyDto(userDto.getAccount(), userDto.getCity(),
                        UserManager.getInstance().getElectricLevel(), userDto.getHeadImageUri(),
                        userDto.getName(), userDto.getPost());
                familyDao.insert(f1);
            }
            dispenseBus.post(new FamilyEvent(true, familyDtoList, "获取家庭列表失败"));
        } else {
            dispenseBus.post(new FamilyEvent(false, null, "暂无网络，请稍后重试"));
        }
    }
}
