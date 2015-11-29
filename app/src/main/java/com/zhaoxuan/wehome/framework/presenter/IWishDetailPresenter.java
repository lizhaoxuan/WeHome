package com.zhaoxuan.wehome.framework.presenter;

import android.graphics.drawable.Drawable;

import com.zhaoxuan.wehome.framework.view.IWishDetailView;
import com.zhaoxuan.wehome.support.dto.WishDto;

/**
 * Created by lizhaoxuan on 15/11/29.
 */
public interface IWishDetailPresenter {

    void setDetailView(IWishDetailView view);

    void initView(int itemId);

    void setIsFinish(boolean isFinish);

    void deleteWish(int position);

    void changeTitle(String title);

    void changeContent(String str);

    void ChangeImg(Drawable drawable);

}
