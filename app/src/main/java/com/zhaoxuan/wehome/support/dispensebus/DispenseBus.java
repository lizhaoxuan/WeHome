package com.zhaoxuan.wehome.support.dispensebus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lizhaoxuan on 16/3/11.
 */
public class DispenseBus {

    private static volatile DispenseBus instance;

    static final String ON_EVENT_NAME = "onEvent";

    public static DispenseBus getInstance() {
        if (instance == null) {
            synchronized (DispenseBus.class) {
                if (instance == null) {
                    instance = new DispenseBus();
                }
            }
        }
        return instance;
    }

    /**
     * 观察者列表,用于object类型索引
     */
    private Map<Object, List<DispenseObserver>> dispenseObservers;


    public DispenseBus() {
        this.dispenseObservers = new HashMap<>();
    }

    public boolean register(Object object) {
        if (dispenseObservers.containsKey(object)) {
            return false;
        }
        List<DispenseObserver> observerList = createDispenseObserver(object);
        dispenseObservers.put(object, observerList);
        return true;
    }

    public boolean register(Object object, int kind) {
        if (dispenseObservers.containsKey(object)) {
            return false;
        }
        List<DispenseObserver> observerList = createDispenseObserver(kind, object);
        dispenseObservers.put(object, observerList);
        return true;
    }

    public void post(Object event) {
        for (List<DispenseObserver> list : dispenseObservers.values()) {
            for (DispenseObserver observer : list) {
                if (observer.equals(event)) {
                    methodInvoke(observer.dispenseMethod.method, observer.object, event);
                }
            }
        }
    }

    public void post(int kind, Object event) {
        for (List<DispenseObserver> list : dispenseObservers.values()) {
            for (DispenseObserver observer : list) {
                if (observer.equals(kind, event)) {
                    methodInvoke(observer.dispenseMethod.method, observer.object, event);
                }
            }
        }
    }

    public void post(String tag, Object event) {
        for (List<DispenseObserver> list : dispenseObservers.values()) {
            for (DispenseObserver observer : list) {
                if (observer.equals(tag, event)) {
                    methodInvoke(observer.dispenseMethod.method, observer.object, event);
                }
            }
        }
    }

    private void methodInvoke(Method method, Object object, Object event) {
        try {
            method.invoke(object, event);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    public void unRegister(Object object) {
        if (object != null) {
            dispenseObservers.remove(object);
        }
    }

    private List<DispenseObserver> createDispenseObserver(Object object) {
        return createDispenseObserver(0, object);
    }

    private List<DispenseObserver> createDispenseObserver(int kind, Object object) {
        List<DispenseObserver> observers = new ArrayList<>();
        List<DispenseMethod> methods = createDispenseMethod(object);

        for (DispenseMethod method : methods) {
            DispenseObserver observer = new DispenseObserver(method, object, kind);
            observers.add(observer);
        }
        return observers;
    }

    private List<DispenseMethod> createDispenseMethod(Object object) {
        List<DispenseMethod> dispenseMethods = new ArrayList<>();
        Method[] methods = object.getClass().getMethods();
        for (Method method : methods) {
            try {
                String me = method.getName().substring(0, ON_EVENT_NAME.length());
                if (me.equals(ON_EVENT_NAME)) {
                    if (method.getParameterTypes().length != 1) {
                        continue;
                    }
                    dispenseMethods.add(new DispenseMethod(method));
                }
            } catch (Exception e) {

            }
        }
        return dispenseMethods;
    }

}
