package com.zhaoxuan.wehome.framework.presenter;

import com.zhaoxuan.wehome.framework.view.IMemorialDayDetailView;

import java.util.Date;

/**
 * Created by lizhaoxuan on 16/1/10.
 */
public interface IMemorialDayDetailPresenter {

    void setDetailView(IMemorialDayDetailView view, int detailPosition);

    void initView();

    int [] getDate();

    void changeMemorialDay(String title ,long date , boolean isLoop);

    void deleteMemorialDay();

    void finishActivity();

    void addMemorialDay(String buildAccount, String buildName, String datetime, int id, boolean loop, String title);


}
