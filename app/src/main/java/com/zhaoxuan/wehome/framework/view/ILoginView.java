package com.zhaoxuan.wehome.framework.view;

import com.zhaoxuan.wehome.support.dto.UserDto;

/**
 * Created by lizhaoxuan on 15/11/12.
 */
public interface ILoginView {

    void loginSuccess(Class clazz);

    void showToast(String tips);

    void showLoading();

    void hideLoading();

    void setAccountEdit(String account);

    void clearEdit();

}
