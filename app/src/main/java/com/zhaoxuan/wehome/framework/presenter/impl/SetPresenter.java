package com.zhaoxuan.wehome.framework.presenter.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.zhaoxuan.wehome.framework.model.ICallBack;
import com.zhaoxuan.wehome.framework.model.ISetModel;
import com.zhaoxuan.wehome.framework.model.impl.SetModel;
import com.zhaoxuan.wehome.framework.presenter.ISetPresenter;
import com.zhaoxuan.wehome.framework.view.ISetView;
import com.zhaoxuan.wehome.support.dto.UserDto;

/**
 * Created by lizhaoxuan on 15/11/26.
 */
public class SetPresenter implements ISetPresenter {
    private ISetView view;
    private ISetModel model;

    public SetPresenter(ISetView view) {
        this.view = view;
        this.model = new SetModel();
    }

    @Override
    public void setValue(int key, String value) {
        if (value.equals("")) {
            view.showToast("值不能为空哦~");
        } else {
            model.setValue(key, value, new ICallBack() {
                @Override
                public <T> void callBackSuccess(T t) {
                    view.showToast((String) t);
                }

                @Override
                public void callBackError(String error) {
                    view.showToast(error);
                }
            });
        }

    }

    @Override
    public void setHeadImg(String path) {
        model.setHeadImg(path, new ICallBack() {
            @Override
            public <T> void callBackSuccess(T t) {
                view.showToast((String) t);
            }

            @Override
            public void callBackError(String error) {
                view.showToast(error);
            }
        });
    }

    @Override
    public void updateView() {
        UserDto user = model.getUserDto();
        if(!user.getHeadImagePath().equals("")){
            Bitmap bitmap = BitmapFactory.decodeFile(user.getHeadImagePath());
            view.updateHeadImg(bitmap);
        }
        view.updateView(user);
    }
}
