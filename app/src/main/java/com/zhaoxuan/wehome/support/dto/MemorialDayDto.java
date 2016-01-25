package com.zhaoxuan.wehome.support.dto;

import com.zhaoxuan.wehome.support.entity.MemorialDayEntity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by lizhaoxuan on 16/1/7.
 */
public class MemorialDayDto extends MemorialDayEntity {

    private static final DateFormat DATE_FORMAT = SimpleDateFormat.getDateInstance();
    private Calendar calendar = GregorianCalendar.getInstance();

    private Date nowDate;
    private Date targetDate;
    private int dateYear;
    private int dateMonth;
    private int dateDay;
    private String nameStr;
    private long day;

    public MemorialDayDto(String buildAccount, String buildName, String datetime, int id, boolean loop, String title) {
        super(buildAccount, buildName, datetime, id, loop, title);
        try {
            nowDate = new Date();
            targetDate = DATE_FORMAT.parse(datetime);
            calendar.setTime(targetDate);
            dateYear = calendar.get(Calendar.YEAR);
            dateMonth = calendar.get(Calendar.MONTH);
            dateDay = calendar.get(Calendar.DATE);
            calculateDate();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public MemorialDayDto(MemorialDayEntity entity){
        super(entity.getBuildAccount(),
                entity.getBuildName(),
                entity.getDatetime(),
                entity.getId(),
                entity.isLoop(),
                entity.getTitle());
    }

    public int getDateYear() {
        return dateYear;
    }

    public int getDateDay() {
        return dateDay;
    }

    public int getDateMonth() {
        return dateMonth;
    }

    public long getDay() {
        return day;
    }

    public String getNameStr() {
        return nameStr;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public String getDayStr() {
        if (day == 0) {
            return "今";
        } else {
            return String.valueOf(day);
        }
    }

    public String getDateStr() {
        return dateYear + "年" + dateMonth + "月" + dateDay + "日";
    }

    /**
     * 计算与给定日期之间的天数
     * <p>
     * 非循环
     * day = now - target
     * nameStr = 已经
     * 循环
     * target-year = now-year
     * nameStr = 还有；
     * if(target < now){
     * day = target - now;
     * }else if (target == now){
     * day = 0;
     * nameStr = 是
     * }else {
     * now-year + 1;
     * day = now - target;
     * }
     */
    private void calculateDate() {
        if (loop) {
            nameStr = "还有";
            calendar.setTime(nowDate);
            int nowYear = calendar.get(Calendar.YEAR);

            calendar.setTime(targetDate);
            calendar.set(Calendar.YEAR, nowYear);

            Date target = calendar.getTime();
            day = target.getTime() - nowDate.getTime();

            if (day == 0) {
                nameStr = "是";
            } else if (day > 0) {
                calendar.setTime(nowDate);
                calendar.add(Calendar.YEAR, 1);
                day = target.getTime() - nowDate.getTime();
            }
        } else {
            nameStr = "已经";
            day = ((nowDate.getTime() - targetDate.getTime()) / 1000 / 60 / 60 / 24);
        }
    }


}
