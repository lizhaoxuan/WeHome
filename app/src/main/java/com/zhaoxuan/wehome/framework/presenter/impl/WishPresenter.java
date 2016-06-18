package com.zhaoxuan.wehome.framework.presenter.impl;

import com.zhaoxuan.wehome.framework.base.BasePresenter;
import com.zhaoxuan.wehome.framework.model.impl.WishModel;
import com.zhaoxuan.wehome.framework.view.IWishView;
import com.zhaoxuan.wehome.module.event.WishEvent;
import com.zhaoxuan.wehome.support.dto.WishDto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lizhaoxuan on 15/11/27.
 */
public class WishPresenter extends BasePresenter implements Serializable {

    private IWishView view;
    private WishModel model;
    private WishDto[] wishList;
    private ArrayList<WishDto> finishWishList = new ArrayList<>();
    private ArrayList<WishDto> unFinishWishList = new ArrayList<>();

    public WishPresenter(IWishView view) {
        this.view = view;
        model = new WishModel();
    }

    public void initData() {
        view.showLoading();
        model.getData();
    }

    public void onEventWishEvent(WishEvent event){
        if (event.isSuccess()){
            wishList = event.getDtos();
            refreshDataList();
            if (wishList == null || wishList.length == 0){
                view.doNoDataTip();
            }
            view.initData(unFinishWishList,finishWishList);
        }else {
            view.showToast(event.getError());
        }
    }

    /**
     * 刷新已完成和未完成List
     */
    private void refreshDataList() {
        finishWishList.clear();
        unFinishWishList.clear();
        if (wishList == null){
            return;
        }
        for (WishDto dto:wishList){
            if (dto.isFinish()) {
                finishWishList.add(dto);
            } else {
                unFinishWishList.add(dto);
            }
        }
    }


}

