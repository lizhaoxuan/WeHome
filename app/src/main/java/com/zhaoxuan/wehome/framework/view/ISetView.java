package com.zhaoxuan.wehome.framework.view;

import android.graphics.Bitmap;

import com.zhaoxuan.wehome.support.dto.UserDto;

/**
 * Created by lizhaoxuan on 15/11/26.
 */
public interface ISetView {

    void updateView(UserDto user);

    void showToast(String msg);

    void updateHeadImg(Bitmap bitmap);

    void hideDialog();

}
