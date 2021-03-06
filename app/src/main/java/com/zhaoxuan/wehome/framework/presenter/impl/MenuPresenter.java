package com.zhaoxuan.wehome.framework.presenter.impl;

import com.zhaoxuan.wehome.WeHomeApplication;
import com.zhaoxuan.wehome.framework.base.BasePresenter;
import com.zhaoxuan.wehome.framework.presenter.IMenuPresenter;
import com.zhaoxuan.wehome.framework.view.IMenuView;
import com.zhaoxuan.wehome.module.event.SetValueEvent;
import com.zhaoxuan.wehome.module.manager.UserManager;
import com.zhaoxuan.wehome.support.dto.UserDto;

/**
 * 侧滑菜单Presenter
 * Created by lizhaoxuan on 15/11/26.
 */
public class MenuPresenter extends BasePresenter implements IMenuPresenter {
    private IMenuView view;

    public MenuPresenter(IMenuView view) {
        this.view = view;
    }

    @Override
    public void updateView() {
        UserDto user = UserManager.getInstance().getUserDto();
        view.setUserData(user);
    }

    public void onEventSetValue(SetValueEvent event) {
        if (event.isSuccess()) {
            updateView();
        }
    }
}
