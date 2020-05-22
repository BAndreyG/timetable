package com.timetable.raspisaniye_timetable.to;

import com.timetable.raspisaniye_timetable.model.Client;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HistoryTo {
    private LocalDateTime date;
    private String day;
    private String time;
    private String clientName;
    private int clientId;
    private String description;
    private int id;
}
