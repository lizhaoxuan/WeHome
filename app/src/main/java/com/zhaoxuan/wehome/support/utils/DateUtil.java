package com.zhaoxuan.wehome.support.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lizhaoxuan on 16/6/17.
 */
public class DateUtil {

    public static final DateFormat DATE_FORMAT = SimpleDateFormat.getDateInstance();

    public static String getDefaultDate(Date date) {
        if (date == null) {
            return "";
        }
        return DATE_FORMAT.format(date);
    }
}
