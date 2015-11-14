package com.zhaoxuan.wehome.framework.presenter.impl;

import com.zhaoxuan.wehome.framework.presenter.ILoginPresenter;
import com.zhaoxuan.wehome.framework.view.ILoginView;
import com.zhaoxuan.wehome.support.constants.Ints;

/**
 * Created by lizhaoxuan on 15/11/12.
 */
public class LoginPresenter implements ILoginPresenter {

    private ILoginView view;

    public LoginPresenter(ILoginView view) {
        this.view = view;
    }

    @Override
    public void login(String account, String password) {
        if (account.equals("") || password.equals("")) {
            view.showToast("账号或密码不能为空哦~");
        } else {

        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, String data) {
        if (resultCode == Ints.RESULT_OK) {
            switch (requestCode) {
                case Ints.INTENT_FORGET: view.setAccountEdit(data);
                    break;
                case Ints.INTENT_REGISTER: view.setAccountEdit(data);
                    break;
            }
        }
    }
}
