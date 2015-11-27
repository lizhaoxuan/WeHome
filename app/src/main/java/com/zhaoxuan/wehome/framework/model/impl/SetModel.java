package com.zhaoxuan.wehome.framework.model.impl;

import com.zhaoxuan.wehome.MyApplication;
import com.zhaoxuan.wehome.framework.model.ICallBack;
import com.zhaoxuan.wehome.framework.model.ISetModel;
import com.zhaoxuan.wehome.support.dto.UserDto;

/**
 * Created by lizhaoxuan on 15/11/26.
 */
public class SetModel implements ISetModel{

    @Override
    public void setValue(int key, String value, ICallBack callBack) {
        MyApplication.getInstance().getUserDto().setValue(key,value);
        callBack.callBackSuccess("修改成功啦~");
    }

    @Override
    public void changePassword(String oldPassword, String newPassword,ICallBack callBack) {
        if (!MyApplication.getInstance().getUserDto().getPassword().equals(oldPassword)){
            callBack.callBackError("旧密码不对哦~请重新输入");
        }else{
            MyApplication.getInstance().getUserDto().setPassword(newPassword);
            callBack.callBackSuccess("密码修改成功啦~");
        }
    }

    @Override
    public void setHeadImg(String path, ICallBack callBack) {
        MyApplication.getInstance().getUserDto().setHeadImagePath(path);
        callBack.callBackSuccess("修改成功啦~");
    }

    @Override
    public UserDto getUserDto() {
        return MyApplication.getInstance().getUserDto();
    }
}
