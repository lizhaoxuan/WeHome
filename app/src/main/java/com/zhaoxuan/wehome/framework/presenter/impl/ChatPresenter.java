package com.zhaoxuan.wehome.framework.presenter.impl;

import android.graphics.drawable.Drawable;

import com.zhaoxuan.wehome.R;
import com.zhaoxuan.wehome.framework.base.BasePresenter;
import com.zhaoxuan.wehome.framework.model.impl.ChatModel;
import com.zhaoxuan.wehome.framework.presenter.IChatAddPresenter;
import com.zhaoxuan.wehome.framework.presenter.IChatPresenter;
import com.zhaoxuan.wehome.framework.view.IChatAddView;
import com.zhaoxuan.wehome.framework.view.IChatView;
import com.zhaoxuan.wehome.module.event.ChatEvent;
import com.zhaoxuan.wehome.module.event.ChatRefreshEvent;
import com.zhaoxuan.wehome.module.event.FamilyPhotoEvent;
import com.zhaoxuan.wehome.module.event.NotificationEvent;
import com.zhaoxuan.wehome.module.manager.NotificationService;
import com.zhaoxuan.wehome.module.manager.UserManager;
import com.zhaoxuan.wehome.support.constants.Ints;
import com.zhaoxuan.wehome.support.dispensebus.DispenseBus;
import com.zhaoxuan.wehome.support.dto.ChatDto;
import com.zhaoxuan.wehome.support.dto.UserDto;
import com.zhaoxuan.wehome.support.utils.DateUtil;
import com.zhaoxuan.wehome.support.utils.StrUtils;

import java.util.Date;

/**
 * Created by lizhaoxuan on 16/6/18.
 */
public class ChatPresenter extends BasePresenter implements IChatPresenter, IChatAddPresenter {

    private IChatView view;
    private IChatAddView addView;
    private ChatModel model;

    public ChatPresenter(IChatView view) {
        this.view = view;
        init();
    }

    public ChatPresenter(IChatAddView addView) {
        this.addView = addView;
        init();
    }

    private void init() {
        model = new ChatModel();
    }

    @Override
    public void getData() {
        model.getData();
    }

    @Override
    public void changeFamilyPhoto(String pathStr) {
        model.setFamilyPhoto(pathStr);
    }


    @Override
    public void addChat(String msg, String picPath) {
        if (StrUtils.isNullStr(msg)) {
            addView.showToast("内容不能为空");
        }
        UserDto userDto = UserManager.getInstance().getUserDto();
        ChatDto chatDto = new ChatDto();
        chatDto.setBuildAccount(userDto.getAccount());
        chatDto.setBuildOf(userDto.getFullName());
        chatDto.setContent(msg);
        chatDto.setPicPath(picPath);
        chatDto.setTime(DateUtil.getDefaultDate(new Date()));
        model.addChatData(chatDto);
    }

    public void onEventFamilyPhoto(FamilyPhotoEvent event) {
        if (!StrUtils.isNullStr(event.getMsg())) {
            view.showToast(event.getMsg());
        }
        if (event.isSuccess()) {
            String path = event.getPath();
            if (path != null) {
                Drawable drawable = Drawable.createFromPath(path);
                view.updatePhoto(drawable);
            }
        }
    }

    public void onEventNotificationEvent(NotificationEvent event) {
        if (event != null) {
            NotificationService.getInstance().pushNotification(event.getTitle(), event.getDes());
            ChatDto chatDto = new ChatDto();
            chatDto.setBuildAccount("WeHome");
            chatDto.setBuildOf("0000");
            chatDto.setContent(event.getDes() + ",快去看看吧~");
            chatDto.setHeadPath(String.valueOf(R.drawable.logo));
            chatDto.setTime(DateUtil.getDefaultDate(new Date()));
            chatDto.setPicPath("");
            model.addChatData(chatDto);
            model.getData();
        }
    }

    public void onEventChatRefreshEvent(ChatRefreshEvent event) {
        if (view != null) {
            model.getData();
        }
    }

    public void onEventChat(ChatEvent event) {
        if (event.getKind() == Ints.DATA_LOAD) {
            view.requestEnd();
            if (event.isSuccess()) {
                view.updateView(event.getChatDtos());
            } else {
                view.showToast(event.getMsg());
            }
        } else if (event.getKind() == Ints.DATA_ADD && addView != null) {
            addView.showToast(event.getMsg());
            if (event.isSuccess()) {
                addView.finishActivity();
                DispenseBus.getInstance().post(new ChatRefreshEvent());
            }
        }
    }
}



