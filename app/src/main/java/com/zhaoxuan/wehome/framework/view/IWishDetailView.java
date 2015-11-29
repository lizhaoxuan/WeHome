package com.zhaoxuan.wehome.framework.view;

import android.graphics.drawable.Drawable;

/**
 * Created by lizhaoxuan on 15/11/29.
 */
public interface IWishDetailView {

    void updateView(String time,String buildOF,String isFinishStr,boolean isFinish,String title,String content);

    void updateImg(Drawable drawable);

    void updateFinishBtn(boolean isFinish);
}
