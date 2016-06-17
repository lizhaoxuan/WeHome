package com.zhaoxuan.wehome.framework.model;

import android.util.SparseArray;

import com.zhaoxuan.wehome.support.dto.MemorialDto;

/**
 * Created by lizhaoxuan on 16/1/11.
 */
public interface IMemorialModel {

    void getData();

    void changeData(MemorialDto wishDto, ICallBack<SparseArray<MemorialDto>> callBack);

}
