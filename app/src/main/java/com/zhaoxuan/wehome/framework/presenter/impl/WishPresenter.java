package com.zhaoxuan.wehome.framework.presenter.impl;

import android.graphics.drawable.Drawable;
import android.util.SparseArray;

import com.zhaoxuan.wehome.framework.base.BasePresenter;
import com.zhaoxuan.wehome.framework.model.ICallBack;
import com.zhaoxuan.wehome.framework.model.IWishModel;
import com.zhaoxuan.wehome.framework.model.impl.WishModel;
import com.zhaoxuan.wehome.framework.presenter.IWishDetailPresenter;
import com.zhaoxuan.wehome.framework.presenter.IWishPresenter;
import com.zhaoxuan.wehome.framework.view.IWishDetailView;
import com.zhaoxuan.wehome.framework.view.IWishView;
import com.zhaoxuan.wehome.module.tool.StrUtils;
import com.zhaoxuan.wehome.support.dto.WishDto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lizhaoxuan on 15/11/27.
 */
public class WishPresenter extends BasePresenter implements IWishPresenter, IWishDetailPresenter, Serializable {

    private IWishView view;
    private IWishModel model;
    private IWishDetailView detailView;
    private SparseArray<WishDto> wishList;
    private ArrayList<WishDto> finishWishList;
    private ArrayList<WishDto> unFinishWishList;
    private int detailPosition;

    public WishPresenter() {
        model = new WishModel();
    }

    public void setView(IWishView view) {
        this.view = view;
    }

    @Override
    public void initData() {
        view.showLoading();
        model.getData(new ICallBack<SparseArray<WishDto>>() {
            @Override
            public void callBackSuccess(SparseArray<WishDto> t) {
                finishWishList = new ArrayList<>();
                unFinishWishList = new ArrayList<>();
                wishList = t;
                refreshDataList();
                view.initData(finishWishList, unFinishWishList);
                view.requestEnd();
            }

            @Override
            public void callBackError(String error) {
                view.requestEnd();
            }
        });
    }

    /*--------- 计划详情P方法 ------------*/

    @Override
    public void setDetailView(IWishDetailView detailView, int detailPosition) {
        this.detailView = detailView;
        this.detailPosition = detailPosition;
    }

    @Override
    public void initView() {
        if (detailView == null || detailPosition == -1) {
            throw new NoClassDefFoundError("not fount detailView or detailPosition");
        } else {
            detailView.updateView(wishList.get(detailPosition));
        }
    }

    @Override
    public void addWish(Drawable drawable, String time, String buildOf, String title, String content) {


        refreshDataList();
    }

    @Override
    public void deleteWish() {
        wishList.remove(detailPosition);
        refreshDataList();
        detailView.finishActivity();

    }

    @Override
    public void changeWish(String title, String content) {
        if (StrUtils.isNullStr(title) || StrUtils.isNullStr(content)) {
            view.showToast("标题或内容不能为空");
            return;
        }


        wishList.get(detailPosition).setTitle(title);
        wishList.get(detailPosition).setWishContent(content);
    }

    @Override
    public void changeWishImg(Drawable drawable) {


    }

    @Override
    public void changeFinish(boolean isFinish) {
        if (isFinish != wishList.get(detailPosition).isFinish()) {
            wishList.get(detailPosition).setIsFinish(isFinish);
            refreshDataList();
        }
    }

    /**
     * 刷新已完成和未完成List
     */
    private void refreshDataList() {
        finishWishList.clear();
        unFinishWishList.clear();
        for (int i = 0; i < wishList.size(); i++) {
            if (wishList.get(i).isFinish()) {
                finishWishList.add(wishList.valueAt(i));
            } else {
                unFinishWishList.add(wishList.valueAt(i));
            }
        }
    }


}

