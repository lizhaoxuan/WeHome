package com.zhaoxuan.wehome.framework.presenter.impl;

import com.zhaoxuan.wehome.framework.model.ICallBack;
import com.zhaoxuan.wehome.framework.model.IWishModel;
import com.zhaoxuan.wehome.framework.model.impl.WishModel;
import com.zhaoxuan.wehome.framework.presenter.IWishPresenter;
import com.zhaoxuan.wehome.framework.view.IWishView;
import com.zhaoxuan.wehome.support.dto.WishDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhaoxuan on 15/11/27.
 */
public class WishPresenter implements IWishPresenter {

    private IWishView view;
    private IWishModel model;

    public WishPresenter(IWishView view) {
        this.view = view;
        model = new WishModel();
    }

    @Override
    public void getData() {
        view.showLoading();
        model.getData(new ICallBack() {
            @Override
            public <T> void callBackSuccess(T t) {
                view.updateView((ArrayList<WishDto>)t);
                requestEnd();
            }

            @Override
            public void callBackError(String error) {
                view.showToast(error);
                requestEnd();
            }
        });
    }

    private void requestEnd(){
        view.hideLoading();
        view.doNoDataTip();
    }
    private void requestEnd(String msg){

    }
}
