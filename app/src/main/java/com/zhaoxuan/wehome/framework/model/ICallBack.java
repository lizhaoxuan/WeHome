package com.zhaoxuan.wehome.framework.model;

/**
 * Created by lizhaoxuan on 15/11/14.
 */
public interface ICallBack<T> {

    void callBackSuccess(T t);

    void callBackError(String error);

}
