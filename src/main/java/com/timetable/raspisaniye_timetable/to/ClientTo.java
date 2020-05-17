package com.timetable.raspisaniye_timetable.to;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ClientTo {
    private int id;
    private String name;
    private String adres;
    private boolean enabled;
    private LocalDateTime registered;
    private int tel;
    private String description;

    public ClientTo(){}

}
