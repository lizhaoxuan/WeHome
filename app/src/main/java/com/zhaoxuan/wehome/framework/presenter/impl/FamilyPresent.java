package com.zhaoxuan.wehome.framework.presenter.impl;

import com.zhaoxuan.wehome.framework.base.BasePresenter;
import com.zhaoxuan.wehome.framework.model.ICallBack;
import com.zhaoxuan.wehome.framework.model.IFamilyModel;
import com.zhaoxuan.wehome.framework.model.impl.FamilyModel;
import com.zhaoxuan.wehome.framework.presenter.IFamilyPresenter;
import com.zhaoxuan.wehome.framework.view.IFamilyView;
import com.zhaoxuan.wehome.module.event.ElectricEvent;
import com.zhaoxuan.wehome.module.event.FamilyEvent;
import com.zhaoxuan.wehome.module.manager.UserManager;
import com.zhaoxuan.wehome.support.dto.FamilyDto;
import com.zhaoxuan.wehome.support.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhaoxuan on 16/2/23.
 */
public class FamilyPresent extends BasePresenter implements IFamilyPresenter {

    private IFamilyView view;
    private IFamilyModel model;
    private List<FamilyDto> familyDtos;

    public FamilyPresent(IFamilyView view) {
        this.view = view;
        model = new FamilyModel();
    }

    @Override
    public void initData() {
        view.showLoading();
        model.getData();
    }

    public void onEventFamily(FamilyEvent event){
        if (event.isSuccess()){
            familyDtos = event.getFamilyDtos();
            if (familyDtos == null || familyDtos.size() == 0){
                view.doNoDataTip();
            }
            view.init(familyDtos);
        }else {
            view.showToast(event.getMsg());
        }
    }

    public void onEventFamily(ElectricEvent event){
        UserDto userDto = UserManager.getInstance().getUserDto();
        if (familyDtos!= null){
            for (FamilyDto dto : familyDtos){
                if (dto.getAccount().equals(userDto.getAccount())){
                    dto.setElectric(event.getElectric());
                }
            }
            view.init(familyDtos);
        }

    }

}
