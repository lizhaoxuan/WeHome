package com.zhaoxuan.wehome.framework.presenter.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.zhaoxuan.wehome.framework.base.BasePresenter;
import com.zhaoxuan.wehome.framework.model.impl.WishModel;
import com.zhaoxuan.wehome.framework.view.IWishDetailView;
import com.zhaoxuan.wehome.module.event.MemorialDetailEvent;
import com.zhaoxuan.wehome.module.event.WishDetailEvent;
import com.zhaoxuan.wehome.module.manager.UserManager;
import com.zhaoxuan.wehome.support.dto.UserDto;
import com.zhaoxuan.wehome.support.dto.WishDto;
import com.zhaoxuan.wehome.support.utils.StrUtils;

/**
 * Created by lizhaoxuan on 16/6/17.
 */
public class WishDetailPresenter extends BasePresenter {

    private IWishDetailView view;
    private WishDto wishDto;
    private String picPath = "";
    private WishModel wishModel;

    public WishDetailPresenter(IWishDetailView detailView, WishDto wishDto) {
        this.view = detailView;
        this.wishDto = wishDto;
        this.wishModel = new WishModel();
        if (wishDto != null) {
            view.updateView(wishDto);
        } else {
            view.initViewForAdd();
        }
    }

    public void addWish(String time, String title, String content) {
        UserDto userDto = UserManager.getInstance().getUserDto();
        WishDto dto = new WishDto();
        dto.setTitle(title);
        dto.setBuildName(userDto.getName());
        dto.setBuildAccount(userDto.getAccount());
        dto.setBuildPost(userDto.getPost());
        dto.setImgUrl(picPath);
        dto.setIsFinish(false);
        dto.setTime(time);
        dto.setWishContent(content);
        wishModel.addData(dto);
    }

    public void deleteWish() {
        wishModel.deleteData(wishDto);
    }

    public void changeWish(String title, String content) {
        if (StrUtils.isNullStr(title) || StrUtils.isNullStr(content)) {
            view.showToast("标题或内容不能为空");
            return;
        }
        wishDto.setTitle(title);
        wishDto.setWishContent(content);
        wishModel.changeData(wishDto);
    }

    public void changeWishImg(String picPath) {
        this.picPath = picPath;
        if (wishDto != null) {
            wishDto.setImgUrl(picPath);
        }
        if (!picPath.equals("")) {
            Bitmap bitmap = BitmapFactory.decodeFile(picPath);
            view.updateImg(bitmap);
        }
    }

    public void changeFinish(boolean isFinish) {
        wishDto.setIsFinish(isFinish);
        wishModel.changeData(wishDto);
    }

    public void onEventWishDetail(WishDetailEvent event) {
        if (event.isSuccess()) {
            view.showToast(event.getMsg());
            view.finishActivity();
        } else {
            view.showToast(event.getMsg());
        }
    }

}
