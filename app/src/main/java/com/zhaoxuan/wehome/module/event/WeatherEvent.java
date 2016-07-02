package com.zhaoxuan.wehome.module.event;

/**
 * Created by lizhaoxuan on 16/6/22.
 */
public class WeatherEvent {

    private String msg;

    public WeatherEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
