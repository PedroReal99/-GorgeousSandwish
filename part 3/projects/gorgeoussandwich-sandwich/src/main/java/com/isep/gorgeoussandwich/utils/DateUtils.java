package com.isep.gorgeoussandwich.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static boolean isBetweenDates(Date date,int minDate,int maxDate) {
        Date dateFrom = DiferenceBetween(minDate-1);
        Date dateTo = DiferenceBetween(maxDate);
        return dateFrom.compareTo(date) * date.compareTo(dateTo) >= 0;
    }

    public static Date DiferenceBetween(int difDays) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, difDays);
        return calendar.getTime();
    }

}
