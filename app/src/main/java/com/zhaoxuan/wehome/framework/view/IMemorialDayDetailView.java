package com.zhaoxuan.wehome.framework.view;

import com.zhaoxuan.wehome.support.dto.MemorialDayDto;

import java.util.Date;

/**
 * Created by lizhaoxuan on 16/1/11.
 */
public interface IMemorialDayDetailView {

    void updateView(MemorialDayDto memorialDayDto);

    void finishActivity(boolean isChange);

    void showToast(String msg);

    void showLoading();

    void hideLoading();

}
