package com.timetable.raspisaniye_timetable;

import com.timetable.raspisaniye_timetable.model.Client;

import static com.timetable.raspisaniye_timetable.model.AbstractBaseEntity.START_SEQ;

public class ClientTestData {
    public static final int CLIENT_ID=START_SEQ+1;

    public static final Client CLIENT1=new Client();
}
