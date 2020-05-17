package com.timetable.raspisaniye_timetable.util;

import com.timetable.raspisaniye_timetable.model.Client;
import com.timetable.raspisaniye_timetable.to.ClientTo;

public class ClientUtil {
    public static ClientTo toClientTo(Client c,ClientTo ct){
        ct.setId(c.getId());
        ct.setAdres(c.getAdres());
        ct.setDescription(c.getDescription());
        ct.setEnabled(c.isEnabled());
        ct.setRegistered(c.getRegistered());
        ct.setTel(c.getTel());
        ct.setName(c.getName());
        return ct;
    }
}
