package com.zhaoxuan.wehome.framework.base;

/**
 * Created by lizhaoxuan on 16/2/23.
 */
public interface IBaseView {

    void showToast(String msg);

    void showLoading();

    void hideLoading();

    void requestEnd();
}
