package com.zhaoxuan.wehome.module.distribute;

import java.lang.reflect.Method;
import java.util.LinkedList;

/**
 * 任务分发池
 * Created by lizhaoxuan on 16/3/7.
 */
public class DistributePool {

    private static DistributePool instance;

    private LinkedList<DisObserver> observers;

    public DistributePool getInstance() {
        if (instance == null) {
            instance = new DistributePool();
        }
        return instance;
    }

    public void addObserver(DisObserver observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    public void addData(int type, Object data) {
        for (int i = 0, length = observers.size(); i < length; i++) {
            DisObserver observer = observers.get(i);
            //移除无效的观察者
            if (observer == null) {
                observers.remove(i);
                continue;
            }
            //符合条件
            if (foundObserver(data,observer)){
                observer.distributeEvent(data);
            }
        }
    }

    /**
     * 判断是否是目标观察者
     * @param target  目标类型
     * @param observer  观察者
     * @return
     */
    private boolean foundObserver(Object target, DisObserver observer) {
        Class clazz = observer.getClass();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if ("distributeEvent".equals(method.getName())) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (Class<?> clas : parameterTypes) {
                    if (target.getClass().getName().equals(clas.getName()))
                        return true;
                }
            }
        }
        return false;

    }

}
