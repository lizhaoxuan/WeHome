package com.zhaoxuan.wehome.framework.view;

import android.graphics.drawable.Drawable;

import com.zhaoxuan.wehome.framework.base.IBaseListView;
import com.zhaoxuan.wehome.framework.base.IBaseView;
import com.zhaoxuan.wehome.support.dto.ChatDto;
import com.zhaoxuan.wehome.support.dto.FamilyDto;

import java.util.List;

/**
 * Created by lizhaoxuan on 16/6/18.
 */
public interface IChatView extends IBaseListView{


    void updateView(List<ChatDto> chatDtos);

    void updatePhoto(Drawable drawable);

    void showDialog(String msg);
}
