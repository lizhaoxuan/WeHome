package com.zhaoxuan.wehome.framework.model;

import android.util.SparseArray;

import com.zhaoxuan.wehome.support.dto.WishDto;

/**
 * Created by lizhaoxuan on 15/11/29.
 */
public interface IWishDetailModel {

    void changeData(WishDto wishDto,ICallBack<SparseArray<WishDto>> callBack);

}
