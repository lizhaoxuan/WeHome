package com.zhaoxuan.wehome.framework.presenter.impl;

import android.util.SparseArray;

import com.zhaoxuan.wehome.framework.base.BasePresenter;
import com.zhaoxuan.wehome.framework.model.ICallBack;
import com.zhaoxuan.wehome.framework.model.IMemorialDayModel;
import com.zhaoxuan.wehome.framework.model.impl.MemorialDayModel;
import com.zhaoxuan.wehome.framework.presenter.IMemorialDayDetailPresenter;
import com.zhaoxuan.wehome.framework.presenter.IMemorialDayPresenter;
import com.zhaoxuan.wehome.framework.view.IMemorialDayDetailView;
import com.zhaoxuan.wehome.framework.view.IMemorialDayView;
import com.zhaoxuan.wehome.module.event.MemorialEvent;
import com.zhaoxuan.wehome.support.utils.StrUtils;
import com.zhaoxuan.wehome.support.dto.MemorialDayDto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by lizhaoxuan on 16/1/10.
 */
public class MemorialPresenter extends BasePresenter implements IMemorialDayPresenter, IMemorialDayDetailPresenter, Serializable {

    private IMemorialDayView view;
    private IMemorialDayModel model;
    private IMemorialDayDetailView detailView;
    private SparseArray<MemorialDayDto> memorialDataList;
    private MemorialDayDto detailData;

    public MemorialPresenter(IMemorialDayView view) {
        this.view = view;
        model = new MemorialDayModel();
    }

    public void setView(IMemorialDayView view) {
        this.view = view;
    }

    public void setDetailView(IMemorialDayDetailView view) {
        this.detailView = view;
    }


    /** ------ IMemorialDayPresenter -------- **/
    @Override
    public void initData() {
        view.showLoading();
        model.getData();
    }

    public void onEventMemorialData(MemorialEvent event){
        view.hideLoading();
        if (event.isSuccess()){
            memorialDataList = event.getDtos();
            view.initData(memorialDataList.valueAt(0), memorialDataList.valueAt(1),
                    refreshDataList());
            if (memorialDataList == null ||memorialDataList.size() == 0){
                view.doNoDataTip();
            }
        } else {
            view.showToast(event.getError());
        }
    }

    /** ------  IMemorialDayDetailPresenter -------- **/
    @Override
    public void setDetailView(IMemorialDayDetailView view, int detailPosition) {
        this.detailView = view;
        this.detailData = memorialDataList.get(detailPosition);
    }

    @Override
    public void initView() {
        detailView.updateView(detailData);
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

    }

    @Override
    public void changeMemorialDay(String title, long date, boolean isLoop) {
        if (StrUtils.isNullStr(title)) {
            detailView.showToast("标题不能为空");
        }
    }

    @Override
    public void addMemorialDay(String buildAccount, String buildName, String datetime, int id, boolean loop, String title) {

    }


    /**
     * 刷新List
     */
    private List<MemorialDayDto> refreshDataList() {
        List<MemorialDayDto> list = new ArrayList<>();
        for (int i = 2, size = memorialDataList.size(); i < size; i++) {
            list.add(memorialDataList.valueAt(i));
        }
        return list;
    }
}
