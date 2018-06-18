package com.wenliu.coffeeordersystem;

import android.text.format.DateFormat;

import java.util.Calendar;

public class Utils {

    public static String getCreatedTimeTw(long time) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        String year = DateFormat.format("yyyy", calendar).toString();
        String date = DateFormat.format("MMdd", calendar).toString();

        String dateTw = String.valueOf(Integer.valueOf(year) - 1911) + date;

        return dateTw;
    }

    public static String getCreatedTime(long time) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        String date = DateFormat.format("yyyy.M.dd, hh:mm:ss ", calendar).toString();

        return date;
    }


}
