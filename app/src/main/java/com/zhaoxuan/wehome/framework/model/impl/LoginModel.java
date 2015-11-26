package com.zhaoxuan.wehome.framework.model.impl;

import com.zhaoxuan.wehome.MyApplication;
import com.zhaoxuan.wehome.framework.model.ICallBack;
import com.zhaoxuan.wehome.framework.model.ILoginModel;
import com.zhaoxuan.wehome.support.dto.UserDto;

/**
 * Created by lizhaoxuan on 15/11/12.
 */
public class LoginModel implements ILoginModel {

    @Override
    public void login(String account ,String password,ICallBack callBack) {
        //模拟网络请求

        UserDto userDto = new UserDto("690770333@qq.com", "1234567", "卡卡",
                "690770333@qq.com", "吉祥三宝", "爸爸", true, "", "2014-10-10", "","");

        MyApplication.getInstance().setUserDto(userDto);
        //保存到 share 中

        callBack.callBackSuccess(userDto);

    }

    @Override
    public void forgetPassword(String account, ICallBack callBack) {

        callBack.callBackError("这个账号不存在");

    }

    @Override
    public void register(String account, String password, ICallBack callBack) {
        UserDto userDto = new UserDto("1005454329@qq.com", "1234567", "newUser",
                "", "", "", false, "", "", "","");

        MyApplication.getInstance().setUserDto(userDto);

        callBack.callBackSuccess(userDto);

    }
}
