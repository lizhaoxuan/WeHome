package com.zhaoxuan.wehome.framework.view;

import com.zhaoxuan.wehome.support.dto.WZoneDto;
import com.zhaoxuan.wehome.support.dto.WishDto;

import java.util.List;

/**
 * Created by lizhaoxuan on 16/1/15.
 */
public interface IWZoneView {

    void initData(List<WZoneDto> dataList);

    void updateData();

    void showToast(String msg);

    void showLoading();

    void hideLoading();

    void doNoDataTip();

}
