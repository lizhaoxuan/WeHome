package com.zhaoxuan.wehome.framework.presenter;

/**
 * Created by lizhaoxuan on 16/1/10.
 */
public interface IMemorialDetailPresenter {

    void initView();

    int[] getDate();

    void changeMemorialDay(String title, long date, boolean isLoop);

    void deleteMemorialDay();

    void addMemorialDay(String buildAccount, String buildName, long date, boolean loop, String title);


}
