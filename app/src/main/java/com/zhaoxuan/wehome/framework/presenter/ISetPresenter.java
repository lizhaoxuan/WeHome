package com.zhaoxuan.wehome.framework.presenter;

import android.graphics.drawable.Drawable;

import com.zhaoxuan.wehome.support.dto.UserDto;

/**
 * Created by lizhaoxuan on 15/11/26.
 */
public interface ISetPresenter {


    void setValue(int key , String value ,String hint);

    void changePassword(String args1,String args2,String args3);

    void setHeadImg(String path);

    void updateView();

    void logout();

}
