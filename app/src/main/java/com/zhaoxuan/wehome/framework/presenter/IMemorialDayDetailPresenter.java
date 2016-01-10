package com.zhaoxuan.wehome.framework.presenter;

import android.graphics.drawable.Drawable;

import com.zhaoxuan.wehome.framework.view.IMemorialDayView;

import java.util.Date;

/**
 * Created by lizhaoxuan on 16/1/10.
 */
public interface IMemorialDayDetailPresenter {

    void setDetailView(IMemorialDayView view, int detailPosition);

    void initView();

    void setLoop();

    void deleteMemorialDay();

    void changeTime(Date date);

    void ChangeTitle(String title);

    void finishActivity();

    void addMemorialDay(String buildAccount, String buildName, String datetime, int id, boolean loop, String title);


}
