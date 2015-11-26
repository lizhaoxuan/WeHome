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
    public void setHeadImg(String path, ICallBack callBack) {
        MyApplication.getInstance().getUserDto().setHeadImagePath(path);
        callBack.callBackSuccess("修改成功啦~");
    }

    @Override
    public UserDto getUserDto() {
        return MyApplication.getInstance().getUserDto();
    }
}
