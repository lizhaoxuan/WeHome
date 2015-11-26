package com.zhaoxuan.wehome.framework.presenter.impl;

import com.zhaoxuan.wehome.MyApplication;
import com.zhaoxuan.wehome.framework.presenter.IMenuPresenter;
import com.zhaoxuan.wehome.framework.view.IMenuView;

/**
 * Created by lizhaoxuan on 15/11/26.
 */
public class MenuPresenter implements IMenuPresenter {
    private IMenuView view;

    public MenuPresenter(IMenuView view) {
        this.view = view;
    }

    @Override
    public void updateView() {
        view.setUserData(MyApplication.getInstance().getUserDto());
    }
}
