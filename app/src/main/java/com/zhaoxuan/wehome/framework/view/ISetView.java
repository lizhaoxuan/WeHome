package com.zhaoxuan.wehome.framework.view;

import android.graphics.Bitmap;

import com.zhaoxuan.wehome.framework.base.IBaseView;

/**
 * 设置界面view
 * Created by lizhaoxuan on 15/11/26.
 */
public interface ISetView extends IBaseView{

    void updateView(String name, String post, String homeId, String homeName, String city, String account);

    void updateHeadImg(Bitmap bitmap);

}
