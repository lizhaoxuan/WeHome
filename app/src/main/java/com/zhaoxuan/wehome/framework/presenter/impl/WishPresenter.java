package com.zhaoxuan.wehome.framework.presenter.impl;

import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;

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
import java.util.List;

/**
 * Created by lizhaoxuan on 15/11/27.
 */
public class WishPresenter implements IWishPresenter,IWishDetailPresenter,Serializable {

    private IWishView view;
    private IWishModel model;
    private IWishDetailView detailView;
    private <Boolean,WishDto> wishList;
    private ArrayList<WishDto> finishWishList = new ArrayList<>();
    private ArrayList<WishDto> unFinishWishList = new ArrayList<>();

    public WishPresenter(IWishView view) {
        this.view = view;
        model = new WishModel();
    }


    @Override
    public void initData() {
        view.showLoading();
        model.getData(new ICallBack() {
            @Override
            public <T> void callBackSuccess(T t) {
                wishList = (SparseBooleanArray)t;
                Sparse
                for (WishDto dto:wishList) {
                    if(dto.isFinish()){
                        finishWishList.add(dto);
                    }else{
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
    public void setDetailView(IWishDetailView detailView){
        this.detailView = detailView;
    }

    @Override
    public void initView(int itemId) {
        if(detailView == null){
            throw new NoClassDefFoundError("not fount detailView");
        }else{

        }
    }

    @Override
    public void deleteWish(int position) {

    }

    @Override
    public void changeTitle(String title) {

    }

    @Override
    public void changeContent(String str) {

    }

    @Override
    public void ChangeImg(Drawable drawable) {

    }

    @Override
    public void setIsFinish(boolean isFinish) {

    }
}
