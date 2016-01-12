package com.zhaoxuan.wehome.framework.presenter.impl;

import android.graphics.drawable.Drawable;
import android.util.ArrayMap;

import com.zhaoxuan.wehome.framework.model.ICallBack;
import com.zhaoxuan.wehome.framework.model.IWishModel;
import com.zhaoxuan.wehome.framework.model.impl.WishModel;
import com.zhaoxuan.wehome.framework.presenter.IWishDetailPresenter;
import com.zhaoxuan.wehome.framework.presenter.IWishPresenter;
import com.zhaoxuan.wehome.framework.view.IWishDetailView;
import com.zhaoxuan.wehome.framework.view.IWishView;
import com.zhaoxuan.wehome.support.dto.WishDto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lizhaoxuan on 15/11/27.
 */
public class WishPresenter implements IWishPresenter,IWishDetailPresenter,Serializable {

    private IWishView view;
    private IWishModel model;
    private IWishDetailView detailView;
    private ArrayMap<Integer,WishDto> wishList;
    private int detailPosition;
    private boolean isChanged = false;

    public WishPresenter(IWishView view) {
        this.view = view;
        model = new WishModel();
    }


    @Override
    public void initData() {
        view.showLoading();
        model.getData(new ICallBack<ArrayMap<Integer,WishDto>>() {
            @Override
            public void callBackSuccess(ArrayMap<Integer,WishDto> t) {
                ArrayList<WishDto> finishWishList = new ArrayList<>();
                ArrayList<WishDto> unFinishWishList = new ArrayList<>();
                wishList = t;
                for (WishDto dto : wishList.values()) {
                    if (dto.isFinish()) {
                        finishWishList.add(dto);
                    } else {
                        unFinishWishList.add(dto);
                    }
                }
                view.initData(finishWishList, unFinishWishList);
                requestEnd();
            }

            @Override
            public void callBackError(String error) {
                requestEnd(error);
            }
        });
    }

    /**
     * 成功状态下，请求结束
     */
    private void requestEnd(){
        view.hideLoading();
        view.doNoDataTip();
    }

    /**
     * 失败状态下，请求结束
     * @param msg
     */
    private void requestEnd(String msg){
        view.showToast(msg);
        requestEnd();
    }

    /*--------- 计划详情P方法 ------------*/

    @Override
    public void setDetailView(IWishDetailView detailView,int detailPosition){
        this.detailView = detailView;
        this.detailPosition = detailPosition;
        isChanged = false;
    }

    @Override
    public void initView() {
        if(detailView == null || detailPosition == -1){
            throw new NoClassDefFoundError("not fount detailView or detailPosition");
        }else{
            WishDto wishDto = wishList.get(detailPosition);
            detailView.updateView(wishDto.getTime(),
                    wishDto.getFullName(),
                    wishDto.getFinsih(),
                    wishDto.isFinish(),
                    wishDto.getTitle(),
                    wishDto.getWishContent());
        }
    }

    @Override
    public void deleteWish() {
        wishList.remove(detailPosition);
        detailView.finishActivity(true);
    }

    @Override
    public void changeContent(String title,String str) {
        wishList.get(detailPosition).setTitle(title);
        wishList.get(detailPosition).setWishContent(str);
        isChanged = true;
    }

    @Override
    public void ChangeImg(Drawable drawable) {

    }

    @Override
    public void setIsFinish() {
        wishList.get(detailPosition).setIsFinish(!wishList.get(detailPosition).isFinish());
        isChanged = true;
    }

    @Override
    public void addWish(Drawable drawable, String time, String buildOf, String title, String content) {

    }

    @Override
    public void finishActivity() {
        detailView.finishActivity(isChanged);
    }
}

