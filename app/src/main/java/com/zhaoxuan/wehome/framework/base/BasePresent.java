package com.zhaoxuan.wehome.framework.base;

/**
 * Created by lizhaoxuan on 16/2/23.
 */
public class BasePresent {

    protected IBaseView baseView;

    public BasePresent(IBaseView baseView) {
        this.baseView = baseView;
    }

    protected void requestEnd() {
        baseView.hideLoading();
        baseView.doNoDataTip();
    }

    protected void requestEnd(String error) {
        requestEnd();
        baseView.showToast(error);
    }
}
