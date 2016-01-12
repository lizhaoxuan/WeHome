package com.zhaoxuan.wehome.framework.model;

import com.zhaoxuan.wehome.support.dto.UserDto;

/**
 * Created by lizhaoxuan on 15/11/26.
 */
public interface ISetModel {

    void setValue(int key,String value,ICallBack<String> callBack);

    void changePassword(String oldPassword,String newPassword,ICallBack<String> callBack);

    void setHeadImg(String path,ICallBack<String> callBack);

    UserDto getUserDto();



}
