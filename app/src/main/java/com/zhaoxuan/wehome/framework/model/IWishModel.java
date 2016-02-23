package com.zhaoxuan.wehome.framework.model;

import android.util.SparseArray;

import com.zhaoxuan.wehome.support.dto.WishDto;

/**
 * Created by lizhaoxuan on 15/11/27.
 */
public interface IWishModel {

    void getData(ICallBack<SparseArray<WishDto>> callBack);

}
