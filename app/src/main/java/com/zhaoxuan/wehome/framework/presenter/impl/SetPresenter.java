package com.zhaoxuan.wehome.framework.presenter.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.zhaoxuan.wehome.framework.base.BasePresenter;
import com.zhaoxuan.wehome.framework.model.ISetModel;
import com.zhaoxuan.wehome.framework.model.impl.SetModel;
import com.zhaoxuan.wehome.framework.presenter.ISetPresenter;
import com.zhaoxuan.wehome.framework.view.ISetView;
import com.zhaoxuan.wehome.module.event.SetValueEvent;
import com.zhaoxuan.wehome.module.manager.UserManager;
import com.zhaoxuan.wehome.support.dto.UserDto;
import com.zhaoxuan.wehome.support.utils.StrUtils;

/**
 * 设置 presenter
 * Created by lizhaoxuan on 15/11/26.
 */
public class SetPresenter extends BasePresenter implements ISetPresenter {

    private ISetView view;
    private ISetModel model;

    public SetPresenter(ISetView view) {
        this.view = view;
        this.model = new SetModel();
    }

    public void setView(ISetView view) {
        this.view = view;
    }

    @Override
    public void setValue(int key, String value, String hint) {
        if (StrUtils.isNullStr(value)) {
            view.showToast("值不能为空哦~");
        } else if (!value.equals(hint)) {
            model.setValue(key, value);
        }
    }

    @Override
    public void changePassword(String args1, String args2, String args3) {
        if (StrUtils.isNullStr(args1) || StrUtils.isNullStr(args2) || StrUtils.isNullStr(args3)) {
            view.showToast("值不能为空哦~");
        } else if (args2.equals(args3)) {
            view.showToast("两次密码输入不一样，再检查一下吧");
        } else {
            model.changePassword(args1, args2);
        }
    }

    @Override
    public void setHeadImg(String path) {
        if (!StrUtils.isNullStr(path)) {
            model.setHeadImg(path);
        } else {
            view.showToast("图片路径不能为空");
        }
    }

    public void onEventSetValue(SetValueEvent event) {
        view.hideDialog();
        if (event.isSuccess()) {
            updateView();
        }
        view.showToast(event.getMsg());
    }

    @Override
    public void updateView() {
        UserDto user = model.getUserDto();
        if (!user.getHeadImageUri().equals("")) {
            Bitmap bitmap = BitmapFactory.decodeFile(user.getHeadImageUri());
            view.updateHeadImg(bitmap);
        }
        view.updateView(user.getName(), user.getPost(), user.getHomeId(),
                user.getHomeName(), user.getCity(), user.getAccount());
    }

    @Override
    public void logout() {
        UserManager.getInstance().clearSharedForUser();
        view.toLoginActivity();
    }
}
