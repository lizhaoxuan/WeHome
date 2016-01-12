package com.zhaoxuan.wehome.framework.view;

import java.util.Date;

/**
 * Created by lizhaoxuan on 16/1/11.
 */
public interface IMemorialDayDetailView {

    void updateView(String title, Date time, boolean isLoop);

    void updateFinishBtn(boolean isFinish);

    void finishActivity(boolean isChange);

}
