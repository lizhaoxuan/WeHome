package com.zhaoxuan.wehome.framework.presenter.impl;

import com.zhaoxuan.wehome.framework.base.BasePresenter;
import com.zhaoxuan.wehome.framework.model.ICallBack;
import com.zhaoxuan.wehome.framework.model.ISetModel;
import com.zhaoxuan.wehome.framework.model.impl.SetModel;
import com.zhaoxuan.wehome.framework.presenter.ISetPresenter;
import com.zhaoxuan.wehome.framework.view.ISetView;
import com.zhaoxuan.wehome.module.tool.StrUtils;
import com.zhaoxuan.wehome.support.dto.UserDto;

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
    public void setValue(int key, String value) {
        if (StrUtils.isNullStr(value)) {
            view.showToast("值不能为空哦~");
        } else {
//            view.hideDialog();
            model.setValue(key, value, new ICallBack<String>() {
                @Override
                public void callBackSuccess(String t) {
                    view.showToast(t);
                    updateView();
                }

                @Override
                public void callBackError(String error) {
                    view.showToast(error);
                }
            });
        }

    }

    @Override
    public void changePassword(String args1, String args2, String args3) {
        if (StrUtils.isNullStr(args1) || StrUtils.isNullStr(args2) || StrUtils.isNullStr(args3)) {
            view.showToast("值不能为空哦~");
        } else if (args2.equals(args3)) {
            view.showToast("两次密码输入不一样，再检查一下吧");
        } else {
//            view.hideDialog();
            model.changePassword(args1, args2, new ICallBack<String>() {
                @Override
                public void callBackSuccess(String t) {
                    view.showToast(t);
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
        model.setHeadImg(path, new ICallBack<String>() {
            @Override
            public void callBackSuccess(String t) {
                view.showToast(t);
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
//        if (!user.getHeadImagePath().equals("")) {
//            Bitmap bitmap = BitmapFactory.decodeFile(user.getHeadImagePath());
//            view.updateHeadImg(bitmap);
//        }
        view.updateView(user.getName(), user.getPost(), user.getHomeId(),
                user.getHomeName(), user.getCity(), user.getAccount());
    }
}
