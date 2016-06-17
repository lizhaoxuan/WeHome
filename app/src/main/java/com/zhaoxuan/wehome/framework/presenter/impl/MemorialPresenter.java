package com.zhaoxuan.wehome.framework.presenter.impl;

import android.util.SparseArray;

import com.zhaoxuan.wehome.framework.base.BasePresenter;
import com.zhaoxuan.wehome.framework.model.IMemorialModel;
import com.zhaoxuan.wehome.framework.model.impl.MemorialModel;
import com.zhaoxuan.wehome.framework.presenter.IMemorialPresenter;
import com.zhaoxuan.wehome.framework.view.IMemorialDayView;
import com.zhaoxuan.wehome.module.event.MemorialEvent;
import com.zhaoxuan.wehome.support.dto.MemorialDto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhaoxuan on 16/1/10.
 */
public class MemorialPresenter extends BasePresenter implements IMemorialPresenter, Serializable {

    private IMemorialDayView view;
    private MemorialModel model;
    private SparseArray<MemorialDto> memorialDataList;

    public MemorialPresenter(IMemorialDayView view) {
        this.view = view;
        model = new MemorialModel();
    }

    public void setView(IMemorialDayView view) {
        this.view = view;
    }

    /** ------ IMemorialPresenter -------- **/
    @Override
    public void initData() {
        view.showLoading();
        model.getData();
    }

    @Override
    public MemorialDto getData(int position) {
        return memorialDataList.get(position);
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

    /**
     * 刷新List
     */
    private List<MemorialDto> refreshDataList() {
        List<MemorialDto> list = new ArrayList<>();
        for (int i = 2, size = memorialDataList.size(); i < size; i++) {
            list.add(memorialDataList.valueAt(i));
        }
        return list;
    }
}
