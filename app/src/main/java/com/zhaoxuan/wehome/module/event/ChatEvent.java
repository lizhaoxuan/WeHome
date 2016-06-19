package com.zhaoxuan.wehome.module.event;

import com.zhaoxuan.wehome.support.dto.ChatDto;

import java.util.List;

/**
 * Created by lizhaoxuan on 16/6/19.
 */
public class ChatEvent {

    private int kind;
    private boolean isSuccess;
    private String msg;
    private String path;
    private List<ChatDto> chatDtos;

    public ChatEvent(boolean isSuccess, int kind, List<ChatDto> chatDtos, String msg) {
        this.chatDtos = chatDtos;
        this.isSuccess = isSuccess;
        this.kind = kind;
        this.msg = msg;
    }

    public ChatEvent(boolean isSuccess, int kind, String msg) {
        this.isSuccess = isSuccess;
        this.kind = kind;
        this.msg = msg;
    }

    public List<ChatDto> getChatDtos() {
        return chatDtos;
    }

    public void setChatDtos(List<ChatDto> chatDtos) {
        this.chatDtos = chatDtos;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
