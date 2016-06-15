package com.zhaoxuan.wehome.framework.model.impl;

import com.zhaoxuan.wehome.WeHomeApplication;
import com.zhaoxuan.wehome.framework.model.ICallBack;
import com.zhaoxuan.wehome.framework.model.ILoginModel;
import com.zhaoxuan.wehome.support.dto.UserDto;

/**
 * Created by lizhaoxuan on 15/11/12.
 */
public class LoginModel implements ILoginModel {

    @Override
    public void login(String account, String password, ICallBack<UserDto> callBack) {
        //模拟网络请求

        UserDto userDto = new UserDto("690770333@qq.com", "上海", "2016-1-1", "",
                "690770333@qq.com", "吉祥三宝",0, "卡卡", "123456", "爸爸");

//        WeHomeApplication.getInstance().setUserDto(userDto);
        //保存到 share 中

        callBack.callBackSuccess(userDto);

    }

    @Override
    public void forgetPassword(String account, ICallBack<String> callBack) {

        callBack.callBackError("这个账号不存在");

    }

    @Override
    public void register(String account, String password, ICallBack<UserDto> callBack) {
        UserDto userDto = new UserDto("690770333@qq.com", "上海", "", "",
                "", "",0, "卡卡", "123456", "爸爸");

//        WeHomeApplication.getInstance().setUserDto(userDto);

        callBack.callBackSuccess(userDto);

    }
}
