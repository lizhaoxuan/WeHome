package com.zhaoxuan.wehome;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.zhaoxuan.cakedao.CakeDao;
import com.zhaoxuan.wehome.module.manager.WeatherManager;
import com.zhaoxuan.wehome.support.dto.FamilyDto;

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
        initDB();
        initWeather();
    }

    protected void initDB() {
        String dbName = "home_db";
        int version = 2;
        CakeDao.init(this, dbName, version, true);
        CakeDao.instance.classMap.getMap();
    }

    protected void initWeather(){
        WeatherManager.init();


        FamilyDto dto = new FamilyDto();
        dto.setCity("大连");
        WeatherManager.getInstance().getWeather(dto, new WeatherManager.ICallBack() {
            @Override
            public void callBack(FamilyDto dto) {
                Toast.makeText(getInstance(),dto.getWeather(),Toast.LENGTH_SHORT).show();
                Log.d("TAG","====" + dto.getWeather());
            }
        });
    }

}
