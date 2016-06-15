package com.zhaoxuan.wehome.framework.model.impl;

import com.zhaoxuan.wehome.WeHomeApplication;
import com.zhaoxuan.wehome.framework.model.ICallBack;
import com.zhaoxuan.wehome.framework.model.ILoginModel;
import com.zhaoxuan.wehome.module.manager.UserManager;
import com.zhaoxuan.wehome.support.dto.UserDto;
import com.zhaoxuan.wehome.support.utils.NetUtil;

/**
 * Created by lizhaoxuan on 15/11/12.
 */
public class LoginModel implements ILoginModel {

    @Override
    public void login(String account, String password, ICallBack<UserDto> callBack) {
        //模拟网络请求
        if (NetUtil.isConnectingToInternet()) {
            UserDto userDto = new UserDto(account,password, "大连", "2016-1-1", "",
                    "690770333@qq.com", "吉祥三宝", 0, "卡卡", "爸爸");
            UserManager.getInstance().setUserDto(userDto);
            callBack.callBackSuccess(userDto);
        } else {
            callBack.callBackError("网络无法连接，请稍后重试");
        }
    }

    @Override
    public void forgetPassword(String account, ICallBack<String> callBack) {
        if (NetUtil.isConnectingToInternet()) {
            if (account.equals("690770333@qq.com")){
                callBack.callBackSuccess("密码已发到你的邮箱");
            }else {
                callBack.callBackError("这个账号不存在");
            }
        } else {
            callBack.callBackError("网络无法连接，请稍后重试");
        }


    }

    @Override
    public void register(String account, String password, ICallBack<UserDto> callBack) {
        if (NetUtil.isConnectingToInternet()) {
            UserDto userDto = new UserDto(account, password, "大连", "", "",
                    "", "", 0, "卡卡", "爸爸");
            UserManager.getInstance().setUserDto(userDto);
            callBack.callBackSuccess(userDto);
        } else {
            callBack.callBackError("网络无法连接，请稍后重试");
        }
    }
}
