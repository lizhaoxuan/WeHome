package com.zhaoxuan.wehome.framework.presenter.impl;

import android.util.ArrayMap;

import com.zhaoxuan.wehome.framework.model.IWishModel;
import com.zhaoxuan.wehome.framework.presenter.IMemorialDayDetailPresenter;
import com.zhaoxuan.wehome.framework.presenter.IMemorialDayPresenter;
import com.zhaoxuan.wehome.framework.view.IMemorialDayView;
import com.zhaoxuan.wehome.framework.view.IWishDetailView;
import com.zhaoxuan.wehome.framework.view.IWishView;
import com.zhaoxuan.wehome.support.dto.WishDto;

import java.util.Date;

/**
 * Created by lizhaoxuan on 16/1/10.
 */
public class MemorialDayPresenter implements IMemorialDayPresenter, IMemorialDayDetailPresenter {

    private IWishView view;
    private IWishModel model;
    private IWishDetailView detailView;
    private ArrayMap<Integer,WishDto> wishList;
    private int detailPosition;
    private boolean isChanged = false;



    /* IMemorialDayPresenter */
    @Override
    public void initData() {

    }


    /* IMemorialDayDetailPresenter */
    @Override
    public void setLoop() {

    }

    @Override
    public void setDetailView(IMemorialDayView view, int detailPosition) {

    }

    @Override
    public void initView() {

    }

    @Override
    public void deleteMemorialDay() {

    }

    @Override
    public void finishActivity() {

    }

    @Override
    public void ChangeTitle(String title) {

    }

    @Override
    public void changeTime(Date date) {

    }

    @Override
    public void addMemorialDay(String buildAccount, String buildName, String datetime, int id, boolean loop, String title) {

    }
}
