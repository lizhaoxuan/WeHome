package com.zhaoxuan.wehome.framework.presenter.impl;

import com.zhaoxuan.wehome.framework.base.BasePresenter;
import com.zhaoxuan.wehome.framework.model.impl.WZoneModel;
import com.zhaoxuan.wehome.framework.presenter.IWZoneAddPresenter;
import com.zhaoxuan.wehome.framework.presenter.IWZoneDetailPresenter;
import com.zhaoxuan.wehome.framework.presenter.IWZonePresenter;
import com.zhaoxuan.wehome.framework.view.IWZoneAddView;
import com.zhaoxuan.wehome.framework.view.IWZoneDetailView;
import com.zhaoxuan.wehome.framework.view.IWZoneView;
import com.zhaoxuan.wehome.module.event.WZoneEvent;
import com.zhaoxuan.wehome.module.manager.UserManager;
import com.zhaoxuan.wehome.support.constants.Ints;
import com.zhaoxuan.wehome.support.dto.UserDto;
import com.zhaoxuan.wehome.support.dto.WZoneDto;
import com.zhaoxuan.wehome.support.utils.DateUtil;
import com.zhaoxuan.wehome.support.utils.StrUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lizhaoxuan on 16/6/18.
 */
public class WZonePresenter extends BasePresenter implements IWZonePresenter, IWZoneDetailPresenter, IWZoneAddPresenter {

    private IWZoneView view;
    private IWZoneDetailView detailView;
    private IWZoneAddView addView;
    private WZoneDto wzoneDto;
    private List<WZoneDto> wZoneDtoList;
    private WZoneModel model;

    public WZonePresenter(IWZoneAddView addView) {
        this.addView = addView;
        addView.updateView(UserManager.getInstance().getUserDto().getFullName(), DateUtil.getDefaultDate(new Date()));
        init();
    }

    public WZonePresenter(IWZoneDetailView detailView, WZoneDto dto) {
        this.detailView = detailView;
        this.wzoneDto = dto;
        init();
        detailView.updateView(wzoneDto);
    }

    public WZonePresenter(IWZoneView view) {
        this.view = view;
        init();
    }

    private void init() {
        model = new WZoneModel();
    }

    @Override
    public void addData(String picImg, String msg) {
        UserDto userDto = UserManager.getInstance().getUserDto();
        wzoneDto = new WZoneDto();
        wzoneDto.setTime(DateUtil.getDefaultDate(new Date()));
        wzoneDto.setBuildPost(userDto.getPost());
        wzoneDto.setBuildName(userDto.getName());
        wzoneDto.setFamilyAccount(userDto.getHomeId());
        wzoneDto.setFamilyName(userDto.getHomeName());
        wzoneDto.setMsg(msg);
        wzoneDto.setPicUrl(picImg);
        model.addData(wzoneDto);
    }

    @Override
    public void addPraise(String praise) {
        if (StrUtils.isNullStr(praise)) {
            detailView.showToast("评论内容不能为空");
            return;
        }
        praise = UserManager.getInstance().getUserDto().getFullName() + ": " + praise;
        wzoneDto.addPraise(praise);
        model.changeData(wzoneDto);
    }

    @Override
    public void initData() {
        model.getData();
    }

    public void onEventWZone(WZoneEvent event) {
        if (event.getKind() == Ints.DATA_ADD) {
            addView.showToast(event.getMsg());
            if (event.isSuccess()) {
                addView.finishActivity();
            }
        } else if (event.getKind() == Ints.DATA_CHANGE) {
            detailView.showToast(event.getMsg());
            if (event.isSuccess()) {
                detailView.updateView(wzoneDto);
                detailView.clearEdit();
            }
        } else if (event.getKind() == Ints.DATA_LOAD) {
            if (event.isSuccess()) {
                wZoneDtoList = new ArrayList<>();
                WZoneDto[] wZoneDtos = event.getDtos();
                if (wZoneDtos == null || wZoneDtos.length == 0) {
                    view.doNoDataTip();
                } else {
                    for (WZoneDto dto : wZoneDtos) {
                        wZoneDtoList.add(dto);
                    }
                    view.initData(wZoneDtoList);
                }
            } else {
                view.showToast(event.getMsg());
            }
        }
    }

}
