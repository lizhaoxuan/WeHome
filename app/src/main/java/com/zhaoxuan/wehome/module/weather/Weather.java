package com.zhaoxuan.wehome.module.weather;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 天气查询
 * Created by lizhaoxuan on 16/2/23.
 */
public class Weather {

    private static final String WEATHER = "weather";
    private static final String L_TEMP = "l_temp";
    private static final String H_TEMP = "h_temp";


    public static void getWeather(String cityName, WeatherCallBack callBack) {

        callBack.onSuccess(getWeatherStr(new JSONObject()));
    }


    private static String getWeatherStr(JSONObject jsonObject) {
        try {
            return jsonObject.getString(L_TEMP) + "~"
                    + jsonObject.getString(H_TEMP) + "℃ "
                    + jsonObject.getString(WEATHER);
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public interface WeatherCallBack {
        void onSuccess(String weather);
    }

}
