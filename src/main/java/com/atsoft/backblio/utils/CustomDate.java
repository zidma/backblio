package com.atsoft.backblio.utils;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;

public class CustomDate {
    public static Date localFormatedDate(){
        Calendar cl=Calendar.getInstance();
        LocalDate localDate=LocalDate.of(cl.get(Calendar.YEAR),cl.get(Calendar.MONTH)+1,cl.get(Calendar.DAY_OF_MONTH));
        return Date.valueOf(localDate);
    }
}
