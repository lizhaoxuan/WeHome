package com.zhaoxuan.wehome.framework.presenter.impl;

import com.zhaoxuan.wehome.framework.base.BasePresenter;
import com.zhaoxuan.wehome.framework.model.IMemorialModel;
import com.zhaoxuan.wehome.framework.model.impl.MemorialModel;
import com.zhaoxuan.wehome.framework.presenter.IMemorialDetailPresenter;
import com.zhaoxuan.wehome.framework.view.IMemorialDetailView;
import com.zhaoxuan.wehome.module.event.MemorialDetailEvent;
import com.zhaoxuan.wehome.support.dto.MemorialDto;
import com.zhaoxuan.wehome.support.utils.DateUtil;
import com.zhaoxuan.wehome.support.utils.StrUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by lizhaoxuan on 16/6/17.
 */
public class MemorialDetailPresenter extends BasePresenter implements IMemorialDetailPresenter {

    private IMemorialDetailView view;
    private MemorialDto detailData;
    private IMemorialModel model;


    public MemorialDetailPresenter(IMemorialDetailView detailView, MemorialDto dto) {
        this.view = detailView;
        model = new MemorialModel();
        this.detailData = dto;
        if (detailData != null){
            view.updateView(detailData);
        } else {
            view.initViewForAdd();
        }
    }

    @Override
    public void initView() {
        view.updateView(detailData);
    }

    @Override
    public int[] getDate() {
        int[] date = new int[3];
        if (detailData == null) {
            Calendar calendar = GregorianCalendar.getInstance();
            calendar.setTime(new Date());
            date[0] = calendar.get(Calendar.DATE);
            date[1] = calendar.get(Calendar.MONTH);
            date[2] = calendar.get(Calendar.YEAR);
        } else {
            date[0] = detailData.getDateDay();
            date[1] = detailData.getDateMonth();
            date[2] = detailData.getDateYear();
        }
        return date;
    }

    @Override
    public void deleteMemorialDay() {
        model.deleteData(detailData.getId());
    }

    @Override
    public void changeMemorialDay(String title, long date, boolean isLoop) {
        if (StrUtils.isNullStr(title)) {
            view.showToast("标题不能为空");
        }
        detailData.setTitle(title);
        detailData.setDatetime(DateUtil.getDefaultDate(new Date(date)));
        detailData.setLoop(isLoop);
        model.changeData(detailData);
    }

    @Override
    public void addMemorialDay(String buildAccount, String buildName, long date, boolean loop, String title) {
        MemorialDto dto = new MemorialDto();
        dto.setBuildAccount(buildAccount);
        dto.setBuildName(buildName);
        dto.setDatetime(DateUtil.getDefaultDate(new Date(date)));
        dto.setLoop(loop);
        dto.setTitle(title);
        model.addData(dto);
    }

    public void onEventMemorialDetail(MemorialDetailEvent event) {
        if (event.isSuccess()) {
            view.showToast(event.getMsg());
            view.finishActivity(true);
        } else {
            view.showToast(event.getMsg());
        }
    }

}
