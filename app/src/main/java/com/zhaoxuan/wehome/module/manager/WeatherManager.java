package com.zhaoxuan.wehome.module.manager;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.zhaoxuan.cakedao.AbstractCakeDao;
import com.zhaoxuan.cakedao.CakeDao;
import com.zhaoxuan.wehome.module.log.WLog;
import com.zhaoxuan.wehome.support.dto.FamilyDto;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by lizhaoxuan on 16/6/19.
 */
public class WeatherManager {
    private static final String URL = "http://apis.baidu.com/apistore/weatherservice/cityname";
    private static final String BAIDU_API_KEY = "93aae2b925ea5b697a5bc09151838bcb";

    private static final String WEATHER = "weather";
    private static final String L_TEMP = "l_tmp";
    private static final String H_TEMP = "h_tmp";

    private static WeatherManager instance;

    public static WeatherManager init() {
        return instance = new WeatherManager();
    }

    public static WeatherManager getInstance() {
        if (instance == null) {
            instance = new WeatherManager();
        }
        return instance;
    }

    private AbstractCakeDao<FamilyDto> familyDao = CakeDao.getCakeDao(FamilyDto.class);

    public void getWeather(final FamilyDto dto) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String json = request(URL, "cityname=" + dto.getCity());
                dto.setWeather(getWeatherStr(json));
                familyDao.update(dto);
            }
        }).start();
    }

    public void getWeather(final FamilyDto dto, final ICallBack callBack) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final String json = request(URL, "cityname=" + dto.getCity());
                WLog.i("TAG",json);
                dto.setWeather(getWeatherStr(json));
                familyDao.update(dto);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.callBack(dto);
                    }
                });

            }
        }).start();
    }

    private String getWeatherStr(String json) {
        if ("-".equals(json)) {
            return json;
        }
        String result = "-";
        try {
            JSONObject jsonObject = new JSONObject(json).getJSONObject("retData");
            String l_tmp = jsonObject.getString("l_tmp");
            String h_tmp = jsonObject.getString("h_tmp");
            String weather = jsonObject.getString("weather");
            result = l_tmp + "~"
                    + h_tmp + "℃ "
                    + weather;
        } catch (JSONException e) {
            String error = e.getMessage();
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @param httpUrl :请求接口
     * @param httpArg :参数
     * @return 返回结果
     */
    private String request(String httpUrl, String httpArg) {
        BufferedReader reader = null;
        String result = "-";
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + "?" + httpArg;
        Log.e("TAG", " --- " + httpUrl);
        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("GET");
            // 填入apikey到HTTP header
            connection.setRequestProperty("apikey", BAIDU_API_KEY);
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public interface ICallBack {
        void callBack(FamilyDto dto);
    }


    /**
     *
     {
     errNum: 0,
     errMsg: "success",
     retData: {
     city: "北京", //城市
     pinyin: "beijing", //城市拼音
     citycode: "101010100",  //城市编码
     date: "15-02-11", //日期
     time: "11:00", //发布时间
     postCode: "100000", //邮编
     longitude: 116.391, //经度
     latitude: 39.904, //维度
     altitude: "33", //海拔
     weather: "晴",  //天气情况
     temp: "10", //气温
     l_tmp: "-4", //最低气温
     h_tmp: "10", //最高气温
     WD: "无持续风向",	 //风向
     WS: "微风(<10m/h)", //风力
     sunrise: "07:12", //日出时间
     sunset: "17:44" //日落时间
     }
     }
     */

}
