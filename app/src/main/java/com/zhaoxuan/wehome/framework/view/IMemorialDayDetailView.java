package com.zhaoxuan.wehome.framework.view;

import java.util.Date;

/**
 * Created by lizhaoxuan on 16/1/11.
 */
public interface IMemorialDayDetailView {

    void updateView(String title, String date, boolean isLoop);

    void finishActivity(boolean isChange);

    void showToast(String msg);

    void showLoading();

    void hideLoading();

}
