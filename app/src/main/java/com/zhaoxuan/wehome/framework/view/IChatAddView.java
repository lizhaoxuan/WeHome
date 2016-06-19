package com.zhaoxuan.wehome.framework.view;

import com.zhaoxuan.wehome.framework.base.IBaseView;

/**
 * Created by lizhaoxuan on 16/6/19.
 */
public interface IChatAddView extends IBaseView {

    void initView(String buildOf,String time);

    void finishActivity();

    void clearView();

}
