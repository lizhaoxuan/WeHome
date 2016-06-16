package com.zhaoxuan.wehome.module.event;

/**
 * 修改Chat页下拉刷新是否可用
 * Created by lizhaoxuan on 16/6/16.
 */
public class ChatSwipeRefreshEnableEvent {

    private boolean isEnabled;

    public ChatSwipeRefreshEnableEvent(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public boolean isEnabled() {
        return isEnabled;
    }
}
