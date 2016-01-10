package com.zhaoxuan.wehome.framework.view;

import com.zhaoxuan.wehome.support.dto.MemorialDayDto;

import java.util.List;

/**
 * Created by lizhaoxuan on 16/1/10.
 */
public interface IMemorialDayView {

    void initData(List<MemorialDayDto> topList, List<MemorialDayDto> dataList);

    void updateData();

    void showToast(String msg);

    void showLoading();

    void hideLoading();

    void doNoDataTip();

}
