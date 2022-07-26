package com.national.btlock.utils;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * Created by admin on 2016/7/20.
 */
public class DateTimeUtil {
    public static String longToDateStr2(long currentTime) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date dateOld = new Date(currentTime); // 根据long类型的毫秒数生命一个date类型的时间
        String str = sdf.format(dateOld);

        return str;
    }


    public static String intToDateStr2(int currentTime) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        long millions = new Long(currentTime).longValue() * 1000;

        Date dateOld = new Date(millions); // 根据long类型的毫秒数生命一个date类型的时间
        String str = sdf.format(dateOld);

        return str;
    }

    public static int getDiffDays(Date start, String data) {

        int days = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date dateOld = sdf.parse(data);//; new Date(data);
//            Long day =  (dateOld.getTime()-System.currentTimeMillis()+1000 * 60 * 60 * 24)/ (1000 * 60 * 60 * 24);
            Long day = (dateOld.getTime() - start.getTime() + 1000 * 60 * 60 * 24 - 1000) / (1000 * 60 * 60 * 24);
            days = day.intValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        String str=sdf.format(dateOld);
        return days;

    }

    public static String longToDateStr(long currentTime) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateOld = new Date(currentTime); // 根据long类型的毫秒数生命一个date类型的时间
        String str = sdf.format(dateOld);
        return str;
    }

    public static String longToDateMillStr(long currentTime) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date dateOld = new Date(currentTime); // 根据long类型的毫秒数生命一个date类型的时间
        String str = sdf.format(dateOld);
        return str;
    }


    public static Date longToDate(long currentTime) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateOld = new Date(currentTime); // 根据long类型的毫秒数生命一个date类型的时间
//        String str=sdf.format(dateOld);
        return dateOld;
    }


    public static int datetimeCompare(String strNow, String data2) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");//年-月-日 时-分
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//年-月-日 时-分
        try {
            Date dateNow = dateFormat.parse(strNow);//开始时间
//            String EndTime = getTime(date);
            Date date2 = dateFormat.parse(data2);//结束时间

            if (date2.getTime() < dateNow.getTime()) {
                return -1;
            } else if (date2.getTime() == dateNow.getTime()) {
                return 0;
            } else if (date2.getTime() > dateNow.getTime()) {
                return 1;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return -2;
    }

    public static int datetimeCompare2(String strNow, String data2) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//年-月-日 时-分
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//年-月-日 时-分
        try {
            Date dateNow = dateFormat.parse(strNow);//开始时间
//            String EndTime = getTime(date);
            Date date2 = dateFormat.parse(data2);//结束时间

            if (date2.getTime() < dateNow.getTime()) {
                return -1;
            } else if (date2.getTime() == dateNow.getTime()) {
                return 0;
            } else if (date2.getTime() > dateNow.getTime()) {
                return 1;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return -2;
    }


    public static int dateCompare(String data1, String data2) {

//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");//年-月-日 时-分
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//年-月-日 时-分
        try {
            Date date1 = dateFormat.parse(data1);//开始时间
//            String EndTime = getTime(date);
            Date date2 = dateFormat.parse(data2);//结束时间

            if (date2.getTime() < date1.getTime()) {
                return -1;
            } else if (date2.getTime() == date1.getTime()) {
                return 0;
            } else if (date2.getTime() > date1.getTime()) {
                return 1;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return -2;
    }


    public static Date str2DateTime(String dateString) {

        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return date;
    }

    public static Date addMonth(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();
    }

    public static Date addYear(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, n);
        return cal.getTime();
    }


    public static Date addDay(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, n);

        return cal.getTime();
    }

    public static Date addHour(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.add(Calendar.HOUR_OF_DAY, n);

        return cal.getTime();
    }


//    public static String hexTxt2TimeLE(String txt) {
//
//        String result = "";
//        if (!TextUtils.isEmpty(txt) && txt.length() == 8 && !txt.equalsIgnoreCase("00000000")) {
//            try {
//                result = DateTimeUtil.intToDateStr2(Stringy.bytes2Int_LITTLE_ENDIAN(StringUtilBle.hexStringToBytes(txt)));
//            } catch (Exception e) {
//            }
//        }
//
//        return result;
//    }





}
