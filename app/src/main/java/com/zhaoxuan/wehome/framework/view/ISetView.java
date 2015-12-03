package com.zhaoxuan.wehome.framework.view;

import android.graphics.Bitmap;

/**
 * 设置界面view
 * Created by lizhaoxuan on 15/11/26.
 */
public interface ISetView {

    void updateView(String name, String post, String homeId, String homeName, String city, String account);

    void showToast(String msg);

    void updateHeadImg(Bitmap bitmap);

    void hideDialog();

}
