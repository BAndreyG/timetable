package com.timetable.raspisaniye_timetable.util;

import java.time.LocalDate;
public class WeekDate {

    public static LocalDate[] getWeekDate(LocalDate thisDay){
        LocalDate[] localDates=new LocalDate[2];
        localDates[0]=thisDay.minusDays(thisDay.getDayOfWeek().getValue()-1);
        localDates[1]=thisDay.plusDays(7-thisDay.getDayOfWeek().getValue());
        return localDates;
    }
}
