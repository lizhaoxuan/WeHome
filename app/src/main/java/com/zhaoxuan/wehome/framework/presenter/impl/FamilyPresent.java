package com.zhaoxuan.wehome.framework.presenter.impl;

import com.zhaoxuan.wehome.framework.base.BasePresenter;
import com.zhaoxuan.wehome.framework.model.ICallBack;
import com.zhaoxuan.wehome.framework.model.IFamilyModel;
import com.zhaoxuan.wehome.framework.model.impl.FamilyModel;
import com.zhaoxuan.wehome.framework.presenter.IFamilyPresenter;
import com.zhaoxuan.wehome.framework.view.IFamilyView;
import com.zhaoxuan.wehome.support.dto.FamilyDto;

import java.util.List;

/**
 * Created by lizhaoxuan on 16/2/23.
 */
public class FamilyPresent extends BasePresenter implements IFamilyPresenter {

    private IFamilyView view;
    private IFamilyModel model;

    public FamilyPresent(IFamilyView view) {
        this.view = view;
        model = new FamilyModel();
    }

    @Override
    public void initData() {
        view.showLoading();
        model.getData(new ICallBack<List<FamilyDto>>() {
            @Override
            public void callBackSuccess(List<FamilyDto> familyDtos) {
                view.init(familyDtos);
                view.requestEnd();
            }

            @Override
            public void callBackError(String error) {
                view.requestEnd();
                view.showToast(error);
            }
        });
    }


}
