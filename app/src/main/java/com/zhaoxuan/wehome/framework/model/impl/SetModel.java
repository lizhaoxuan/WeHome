package com.zhaoxuan.wehome.framework.model.impl;

import com.zhaoxuan.wehome.framework.model.ISetModel;
import com.zhaoxuan.wehome.module.event.SetValueEvent;
import com.zhaoxuan.wehome.module.manager.UserManager;
import com.zhaoxuan.wehome.support.dispensebus.DispenseBus;
import com.zhaoxuan.wehome.support.dto.UserDto;

/**
 * Created by lizhaoxuan on 15/11/26.
 */
public class SetModel implements ISetModel {

    private UserManager userManager;
    private DispenseBus dispenseBus;

    public SetModel() {
        this.userManager = UserManager.getInstance();
        this.dispenseBus = DispenseBus.getInstance();
    }

    @Override
    public void setValue(int key, String value) {
        userManager.setUserValue(key, value);
        dispenseBus.post(new SetValueEvent(true, "修改成功啦~"));
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        if (!userManager.getUserDto().getPassword().equals(oldPassword)) {
            dispenseBus.post(new SetValueEvent(false, "旧密码不对哦~请重新输入"));
        } else {
            userManager.setUserValue(UserDto.KEY_PASSWORD, newPassword);
            dispenseBus.post(new SetValueEvent(true, "密码修改成功啦~"));
        }
    }

    @Override
    public void setHeadImg(String path) {
        userManager.setUserValue(UserDto.KEY_HEAD_IMAGE_URI, path);
        dispenseBus.post(new SetValueEvent(true, "头像修改成功啦~"));
    }

    @Override
    public UserDto getUserDto() {
        return userManager.getUserDto();
    }
}
