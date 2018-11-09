package com.bob.www.xtimeutilslib;

import android.support.annotation.NonNull;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class XTimeUtils {

    /**
     * 获取所给日期的当前的星期
     * @param date
     *          日期
     * @return
     *          转换为所在星期
     */
    public static String getDayOfWeek(@NonNull Date date) {
        Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getDefault());
        c.setTime(date);
        return baseGetDayOfWeek(c);
    }

    /**
     * 获取所给时间戳的当前星期
     * @param timeStamp
     *          Unix时间戳
     * @return
     *          转换为所在星期
     */
    public static String getDayOfWeek(long timeStamp) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(timeStamp*1000);
        return baseGetDayOfWeek(c);
    }

    /**
     * 根据输入类型自行匹配转换成所在星期
     * @param obj
     *          输入对象
     * @return
     *          转换为所在星期
     */
    public static String getDayOfWeek(@NonNull Object obj) {
        if (obj instanceof Date) {
            return getDayOfWeek(((Date) obj));
        } else if (obj instanceof Long) {
            return getDayOfWeek((((Long) obj).longValue()));
        } else if (obj instanceof Calendar) {
            return baseGetDayOfWeek(((Calendar) obj));
        } else {
            throw new IllegalArgumentException("Your param is not a time!");
        }
    }



    private static String baseGetDayOfWeek(Calendar c) {
        String week="";
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            week = "日";
        }else if (c.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
            week = "一";
        }else if (c.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
            week = "二";
        }else if (c.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
            week = "三";
        } else if (c.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
            week = "四";
        }else if (c.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
            week = "五";
        }else if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            week = "六";
        }
        return week;
    }
}
