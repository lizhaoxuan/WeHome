package com.zhaoxuan.wehome.support.utils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lizhaoxuan on 16/2/23.
 */
public class StrUtils {
    private static final String TAG = StrUtils.class.getSimpleName();

    private static final Gson GSON = new Gson();

    private StrUtils() {
    }

    public static boolean isNullStr(String str) {
        return str == null || str.equals("");
    }

    public static String getStr(String str) {
        return str == null ? "" : str;
    }

    public static <T> T fromJson(String json, Class<T> classOfT) throws JsonSyntaxException {
        return GSON.fromJson(json, classOfT);
    }

    public static String toJson(Object src) {
        return GSON.toJson(src);
    }

    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }

}
