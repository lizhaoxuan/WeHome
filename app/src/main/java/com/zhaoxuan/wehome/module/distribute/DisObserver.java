package com.zhaoxuan.wehome.module.distribute;

/**
 * 分发组件 - 观察者
 * Created by lizhaoxuan on 16/3/7.
 */
public interface DisObserver<T> {

    void distributeEvent(T data);

}
