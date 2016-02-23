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

    void addWish(Drawable drawable, String time, String buildOf, String title, String content);

    void deleteWish();

    void changeFinish(boolean isFinish);

    void changeWish(String title, String content);

    void changeWishImg(Drawable drawable);


}
