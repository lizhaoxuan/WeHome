package com.zhaoxuan.wehome.support.dispensebus;

/**
 * 观察者
 * 分发类型，默认为0，表示全部分发
 * Created by lizhaoxuan on 16/3/11.
 */
public class DispenseObserver {


    final Object object;
    final DispenseMethod dispenseMethod;
    final int kind;

    public DispenseObserver(DispenseMethod dispenseMethod, Object object, int kind) {
        this.dispenseMethod = dispenseMethod;
        this.object = object;
        this.kind = kind;
    }

    public boolean equals(Object event) {
        if (event == null || dispenseMethod == null) {
            return false;
        }
        return dispenseMethod.equals(event);
    }

    public boolean equals(int kind, Object event) {
        if (event == null || dispenseMethod == null) {
            return false;
        }
        return this.kind == kind && dispenseMethod.equals(event);
    }

    public boolean equals(String tag, Object event) {
        if (event == null || dispenseMethod == null) {
            return false;
        }
        return dispenseMethod.equals(tag, event);
    }
}
