package com.zhaoxuan.wehome.framework.presenter.impl;

import android.util.ArrayMap;
import android.util.Log;

import com.zhaoxuan.wehome.framework.model.IMemorialDayModel;
import com.zhaoxuan.wehome.framework.presenter.IMemorialDayDetailPresenter;
import com.zhaoxuan.wehome.framework.presenter.IMemorialDayPresenter;
import com.zhaoxuan.wehome.framework.view.IMemorialDayDetailView;
import com.zhaoxuan.wehome.framework.view.IMemorialDayView;
import com.zhaoxuan.wehome.support.dto.MemorialDayDto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by lizhaoxuan on 16/1/10.
 */
public class MemorialDayPresenter implements IMemorialDayPresenter, IMemorialDayDetailPresenter, Serializable {

    private IMemorialDayView view;
    private IMemorialDayModel model;
    private IMemorialDayDetailView detailView;
    private ArrayMap<Integer, MemorialDayDto> memorilaDataList;
    private boolean isChanged = false;
    private MemorialDayDto detailData;


    /* IMemorialDayPresenter */
    @Override
    public void initData() {

    }


    /* IMemorialDayDetailPresenter */
    @Override
    public void setDetailView(IMemorialDayDetailView view, int detailPosition) {
        this.detailView = view;
        this.detailData = memorilaDataList.get(detailPosition);
    }

    @Override
    public void initView() {

    }

    @Override
    public int[] getDate() {
        int[] date = new int[3];
        if (detailData == null) {
            Calendar calendar = GregorianCalendar.getInstance();
            calendar.setTime(new Date());
            date[0]=calendar.get(Calendar.DATE);
            date[1]=calendar.get(Calendar.MONTH);
            date[2]=calendar.get(Calendar.YEAR);
        } else {
            date[0] = detailData.getDateDay();
            date[1] = detailData.getDateMonth();
            date[2] = detailData.getDateYear();
        }
        return date;
    }

    @Override
    public void deleteMemorialDay() {

    }

    @Override
    public void changeMemorialDay(String title, long date, boolean isLoop) {
        Log.d("TGA",title+date+isLoop);
    }

    @Override
    public void addMemorialDay(String buildAccount, String buildName, String datetime, int id, boolean loop, String title) {

    }
}
