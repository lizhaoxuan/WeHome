package com.zhaoxuan.wehome.framework.presenter;

import android.graphics.drawable.Drawable;

import com.zhaoxuan.wehome.framework.view.IWishDetailView;
import com.zhaoxuan.wehome.support.dto.WishDto;

/**
 * Created by lizhaoxuan on 15/11/29.
 */
public interface IWishDetailPresenter {

    void setDetailView(IWishDetailView view, int detailPosition);

    void initView();

    void setIsFinish();

    void deleteWish();

    void changeContent(String title, String str);

    void ChangeImg(Drawable drawable);

    void finishActivity();

    void addWish(Drawable drawable,String time,String buildOf,String title,String content);
}
