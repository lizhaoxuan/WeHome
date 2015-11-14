package com.zhaoxuan.wehome.framework.model;


/**
 * Created by lizhaoxuan on 15/11/12.
 */
public interface ILoginModel {

    void login(String account ,String password,ICallBack callBack );

    void forgetPassword(String account,ICallBack callBack);

    void register(String account ,String password,ICallBack callBack);

}
