package com.timetable.raspisaniye_timetable.service;

import com.timetable.raspisaniye_timetable.model.Client;
import javassist.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ClientServiceTest {

    @Autowired
    protected ClientService service;

    @Test
    void getId() {
        Client result=new Client();
//        assertThrows();
    }

    @Test
    void NotFound() throws Exception{
        Client client=service.getId(100003);
        assertNotNull(client);
    }
}