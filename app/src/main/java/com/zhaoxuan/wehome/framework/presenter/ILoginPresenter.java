package com.zhaoxuan.wehome.framework.presenter;

/**
 * Created by lizhaoxuan on 15/11/12.
 */
public interface ILoginPresenter {


    void login(String account, String password);

    void onActivityResult(int requestCode, int resultCode, String data);

}
