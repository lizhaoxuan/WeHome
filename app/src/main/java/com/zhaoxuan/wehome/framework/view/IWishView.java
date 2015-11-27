package com.zhaoxuan.wehome.framework.view;

import com.zhaoxuan.wehome.support.dto.WishDto;

import java.util.List;

/**
 * Created by lizhaoxuan on 15/11/27.
 */
public interface IWishView {

    void initData(List<WishDto> unFinishList,List<WishDto> finishList);

    void updateData();

    void showToast(String msg);

    void showLoading();

    void hideLoading();

    void doNoDataTip();

}
