package com.zhaoxuan.wehome.framework.view;

import com.zhaoxuan.wehome.framework.base.IBaseView;

/**
 * Created by lizhaoxuan on 16/6/18.
 */
public interface IWZoneAddView extends IBaseView {

    void updateView(String buildOf,String time);

    void finishActivity();
}
