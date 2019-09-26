package com.wifi.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    private static final String DEFAULT_GOOD_FORMAT_OF_FULL_DATE = "yyyy-MM-dd HH:mm:ss";

    private DateUtils() {
    }

    private static final SimpleDateFormat getFormat(String format) {
        SimpleDateFormat f = new SimpleDateFormat(format);
        return f;
    }

    public static final Date string2DateTime(String yyyyMMddhhmmss) {
        Date dt;
        SimpleDateFormat sdfDateTime = getFormat("yyyyMMddHHmmss");
        try {
            dt = sdfDateTime.parse(yyyyMMddhhmmss);
        } catch (ParseException e) {
            throw new RuntimeException("Parse String to Date Error!", e);
        }
        return dt;
    }

    public static final Date string2DateTime(String formatStr , String dateStr) {
        Date dt;
        SimpleDateFormat sdfDateTime = getFormat(formatStr);
        try {
            dt = sdfDateTime.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException("Parse String to Date Error!", e);
        }
        return dt;
    }

    public static final Date string2Date(String yyyyMMdd) {
        Date dt;
        SimpleDateFormat sdfDate = getFormat("yyyyMMdd");
        try {
            dt = sdfDate.parse(yyyyMMdd);
        } catch (ParseException e) {
            throw new RuntimeException("Parse String to Date Error!", e);
        }
        return dt;
    }

    public static final String date2String(Date date) {
        SimpleDateFormat sdfDate = getFormat("yyyyMMdd");
        return sdfDate.format(date);
    }

    public static final String datetime2String(Date date) {
        return date2String(date, "yyyyMMddHHmmss");
    }

    public static final String date2String(Date date, String format) {
        SimpleDateFormat sdf = getFormat(format);
        return sdf.format(date);
    }

    public static final String time2String(Date date) {
        return date2String(date, "yyyyMMddHHmmss").substring(8);
    }

    public static final Date string2Time(String hhmmss) {
        Date dt;
        SimpleDateFormat sdfTime = getFormat("HHmmss");
        try {
            dt = sdfTime.parse(hhmmss);
        } catch (ParseException e) {
            throw new RuntimeException("Parse String to Date Error!", e);
        }
        return dt;
    }

    public static final String tomorrow(String yyyyMMdd) {
        Date dt = string2Date(yyyyMMdd);
        Date tomorrow = org.apache.commons.lang3.time.DateUtils.addDays(dt, 1);
        SimpleDateFormat sdfDate = getFormat("yyyyMMdd");
        return sdfDate.format(tomorrow);
    }

    public static final String yesterday(String yyyyMMdd) {
        Date dt = string2Date(yyyyMMdd);
        Date yesterday = org.apache.commons.lang3.time.DateUtils.addDays(dt, -1);
        SimpleDateFormat sdfDate = getFormat("yyyyMMdd");
        return sdfDate.format(yesterday);
    }

    public static final String getCurrentTime() {
        SimpleDateFormat sdfTime = getFormat("HHmmss");
        return sdfTime.format(new Date());
    }

    public static final String getCurrentDate() {
        SimpleDateFormat sdfDate = getFormat("yyyyMMdd");
        return sdfDate.format(new Date());
    }

    public static final String getCurrentDateTime() {
        SimpleDateFormat sdfDateTime = getFormat("yyyyMMddHHmmss");
        return sdfDateTime.format(new Date());
    }

    public static final String getCurrentDateTimeReadable() {
        SimpleDateFormat sdfDateTimeReadable = getFormat(DEFAULT_GOOD_FORMAT_OF_FULL_DATE);
        return sdfDateTimeReadable.format(new Date());
    }

    public static final String getCurrentDateTime(String format) {
        SimpleDateFormat f = getFormat(format);
        return f.format(new Date());
    }

    public static final Date nextDate(Date date) {
        return org.apache.commons.lang3.time.DateUtils.addDays(date, 1);
    }

    public static final Date preMoreDate(Date date, int day) {
        return org.apache.commons.lang3.time.DateUtils.addDays(date, day * (-1));
    }

    public static final Date preMoreHour(Date date, int hour) {
        return org.apache.commons.lang3.time.DateUtils.addHours(date, hour * (-1));
    }

    public static final Date preMoreMilliseconds(Date date, int milliseconds) {
        return org.apache.commons.lang3.time.DateUtils.addMilliseconds(date, milliseconds * (-1));
    }

    public static final Date addMonths(Date date, int amount) {
        return org.apache.commons.lang3.time.DateUtils.addMonths(date, amount);
    }

    public static final Date readableString2DateTime(String readableStr) {
        SimpleDateFormat sdfDateTimeReadable = getFormat(DEFAULT_GOOD_FORMAT_OF_FULL_DATE);
        Date dt;
        try {
            dt = sdfDateTimeReadable.parse(readableStr);
        } catch (ParseException e) {
            throw new RuntimeException("Parse String to Date Error!", e);
        }
        return dt;
    }

    public static int getYear(Date date) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        return now.get(Calendar.YEAR);
    }

    /**
     * 取得当前月份
     *
     * @param date
     * @return
     */
    public static int getMonth(Date date) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        return now.get(Calendar.MONTH) + 1;
    }

    public static int getDate(Date date) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        return now.get(Calendar.DATE);
    }

    public static int getDayOfWeek(Date date) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        return now.get(Calendar.DAY_OF_WEEK);
    }

    public static boolean isSameDay(Date d1, Date d2) {
        return org.apache.commons.lang3.time.DateUtils.isSameDay(d1, d2);
    }

    public static void main(String[] args) {
        System.out.println(string2Date("20080401"));
        System.out.println(tomorrow("20090431"));
        System.out.println(time2String(new Date()));
        System.out.println(date2String(new Date(), "yyyyMMddHHmmss").substring(8));
        System.out.println(datetime2String(new Date()));
        System.out.println(getYear(new Date()));
        System.out.println(getMonth(new Date()));
        System.out.println(getDayOfWeek(new Date()));
        System.out.println(addMonths(new Date(), 0));
    }

}
