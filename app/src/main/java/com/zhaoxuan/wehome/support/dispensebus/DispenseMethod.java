package com.zhaoxuan.wehome.support.dispensebus;

import java.lang.reflect.Method;

/**
 * Created by lizhaoxuan on 16/3/11.
 */
public class DispenseMethod {

    final Method method;

    final Class<?> eventType;

    final String methodName;

    public DispenseMethod(Method method) {
        this.eventType = method.getParameterTypes()[0];
        this.method = method;
        this.methodName = method.getName();
    }

    /**
     * 判断是否post该方法
     *
     * @param event event对象
     * @return true 是
     */
    public boolean equals(Object event) {
        return eventType.equals(event.getClass());
    }

    /**
     * 判断是否post该方法
     *
     * @param tag   方法名tag
     * @param event even对象
     * @return true 是
     */
    public boolean equals(String tag, Object event) {
        try {
            String methodTag = methodName.substring(DispenseBus.ON_EVENT_NAME.length(), methodName.length());
            if (tag.equals(methodTag)) {
                return equals(event);
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
