package com.example.util.utils;

import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Administrator on 2017/7/31.
 */

public class CalendarUtil {


    public static int getYear() {
        return Calendar.getInstance(Locale.CHINA).get(Calendar.YEAR);
    }

    public static int getMonth() {
        return Calendar.getInstance(Locale.CHINA).get(Calendar.MONTH);
    }

    public static int getDayOfMonth() {
        return Calendar.getInstance(Locale.CHINA).get(Calendar.DAY_OF_MONTH);
    }
}
