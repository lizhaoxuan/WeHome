package com.zhaoxuan.wehome;

import android.app.Application;

import com.cakerun.apt.AppInit;
import com.lizhaoxuan.cakerun.CakeRun;
import com.zhaoxuan.cakedao.CakeDao;
import com.zhaoxuan.wehome.module.manager.CrashPatch;
import com.zhaoxuan.wehome.module.manager.FamilyManager;
import com.zhaoxuan.wehome.module.manager.UserManager;
import com.zhaoxuan.wehome.module.manager.WeatherManager;

/**
 * Created by lizhaoxuan on 15/11/12.
 */
public class WeHomeApplication extends Application {
    private static final String TAG = WeHomeApplication.class.getName();

    private static WeHomeApplication mInstance = null;

    public static WeHomeApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        init();

    }

    private void init(){
        //CakeRun需要在Application中第一个初始化
        new CakeRun.Build(this, //Application
                "0.1", //App版本号，
                new CrashPatch(this))  //Crash后响应，就是上面我们实现了ICrashPatch的类
                .setAsyncMonitorTime(1500) // 异步任务在Application结束后持续监控时间 默认1500
                .setMaxRestartNum(5) //Application Crash后，最大重启次数，默认5
                .setAlwaysRestartApp(true) //非Application Crash后 是否一直重启，默认false
                .setResetCrashLogTime(1000*60*60*24*2) //重置Crash日志记录时间（根据App使用频率设置）。默认三天重置一次。
                .build();

        //开始执行application中被注解@AppInit 和 @AsyncInit 修饰了的初始化方法
        CakeRun.getInstance().applicationInit();
//        initDB();
//        initWeather();
    }

    @AppInit(tag = 1)
    protected void initDB() {
        String dbName = "home_db";
        int version = 2;
        CakeDao.init(this, dbName, version, true);
        CakeDao.instance.classMap.getMap();
    }

    @AppInit(tag = 2)
    protected void initWeather(){
        WeatherManager.init();

        if (UserManager.getInstance().getUserDto()!=null){
            FamilyManager.getInstance().checkWeather();
        }

    }

}
