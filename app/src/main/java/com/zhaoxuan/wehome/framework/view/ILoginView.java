package com.zhaoxuan.wehome.framework.view;

import com.zhaoxuan.wehome.framework.base.IBaseView;

/**
 * Created by lizhaoxuan on 15/11/12.
 */
public interface ILoginView extends IBaseView {

    void loginSuccess(Class clazz);

    void setAccountEdit(String account);

    void clearEdit();

}
