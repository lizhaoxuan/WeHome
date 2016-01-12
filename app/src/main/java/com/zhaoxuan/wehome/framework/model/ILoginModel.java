package com.zhaoxuan.wehome.framework.model;


import com.zhaoxuan.wehome.support.dto.UserDto;

/**
 * Created by lizhaoxuan on 15/11/12.
 */
public interface ILoginModel {

    void login(String account, String password, ICallBack<UserDto> callBack);

    void forgetPassword(String account, ICallBack<String> callBack);

    void register(String account, String password, ICallBack<UserDto> callBack);

}
