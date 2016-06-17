package com.zhaoxuan.wehome.framework.model.impl;

import android.util.Log;

import com.zhaoxuan.cakedao.AbstractCakeDao;
import com.zhaoxuan.cakedao.CakeDao;
import com.zhaoxuan.wehome.framework.model.ICallBack;
import com.zhaoxuan.wehome.framework.model.ILoginModel;
import com.zhaoxuan.wehome.module.manager.UserManager;
import com.zhaoxuan.wehome.support.dto.UserDto;
import com.zhaoxuan.wehome.support.utils.NetUtil;

import java.util.Date;

/**
 * Created by lizhaoxuan on 15/11/12.
 */
public class LoginModel implements ILoginModel {

    private AbstractCakeDao<UserDto> userDao = CakeDao.getCakeDao(UserDto.class);

    @Override
    public void login(String account, String password, ICallBack<UserDto> callBack) {
        //模拟网络请求
        if (NetUtil.isConnectingToInternet()) {
            if (userDao.loadAllData() != null) {
                for (UserDto dto : userDao.loadAllData()) {
                    if (dto.getAccount().equals(account) && dto.getPassword().equals(password)) {
                        UserManager.getInstance().setUserDto(dto);
                        callBack.callBackSuccess(dto);
                        return;
                    }
                }
            }
            callBack.callBackError("账号或密码错误");
        } else {
            callBack.callBackError("网络无法连接，请稍后重试");
        }
    }

    @Override
    public void forgetPassword(String account, ICallBack<String> callBack) {
        if (NetUtil.isConnectingToInternet()) {
            callBack.callBackSuccess("密码已发到你的邮箱");
        } else {
            callBack.callBackError("网络无法连接，请稍后重试");
        }


    }

    @Override
    public void register(String account, String password, ICallBack<UserDto> callBack) {
        if (NetUtil.isConnectingToInternet()) {
            UserDto[] dtos = userDao.loadAllData();
            if (userDao.loadAllData() != null) {
                for (UserDto dto : dtos) {
                    if (dto.getAccount().equals(account)) {
                        callBack.callBackError("账号已被注册");
                        return;
                    }
                }
            }
            UserDto userDto = new UserDto(account, password, "大连", "", "",
                    "", "", 0, "卡卡", "爸爸");
            userDto.setFamilyBuild("2016-10-3");
            userDto.setHomeId(account);
            userDto.setHomeName("卡卡一家");

            userDao.insert(userDto);
            callBack.callBackSuccess(userDto);
        } else {
            callBack.callBackError("网络无法连接，请稍后重试");
        }
    }
}
