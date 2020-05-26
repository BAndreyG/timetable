package com.timetable.raspisaniye_timetable.util;

import com.timetable.raspisaniye_timetable.model.History;
import com.timetable.raspisaniye_timetable.to.HistoryTo;

public class HistoryUtil {
    public static HistoryTo toHistoryTo(History h,HistoryTo historyTo){
        historyTo.setDescription(h.getDescription());
        historyTo.setDate(h.getDate());
//        historyTo.setDay(h.getDate().getDayOfWeek().toString().toLowerCase());
        historyTo.setDay(h.getDate().getDayOfWeek().getValue());
        historyTo.setTime(String.valueOf(h.getDate().getHour()));//+":"+h.getDate().getMinute()
        historyTo.setId(h.getId());
        historyTo.setClientId(h.getClient().getId());
        historyTo.setClientName(h.getClient().getName());
        return historyTo;
    }

}
