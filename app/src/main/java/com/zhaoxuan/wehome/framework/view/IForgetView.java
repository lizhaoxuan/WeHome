package com.zhaoxuan.wehome.framework.view;

/**
 * Created by lizhaoxuan on 15/11/14.
 */
public interface IForgetView {

    void sendSuccess(String account);

    void showToast(String tips);

    void showLoading();

    void hideLoading();

}
