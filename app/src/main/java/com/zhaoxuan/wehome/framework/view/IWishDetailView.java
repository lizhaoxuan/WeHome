package com.zhaoxuan.wehome.framework.view;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.zhaoxuan.wehome.framework.base.IBaseView;
import com.zhaoxuan.wehome.support.dto.WishDto;

/**
 * Created by lizhaoxuan on 15/11/29.
 */
public interface IWishDetailView extends IBaseView{

    void updateView(WishDto dto);

    void initViewForAdd();

    void updateImg(Bitmap bitmap);

    void updateFinishBtn(boolean isFinish);

    void finishActivity();


}
