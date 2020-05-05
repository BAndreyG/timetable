package com.timetable.raspisaniye_timetable.controller;

import com.timetable.raspisaniye_timetable.model.Client;
import com.timetable.raspisaniye_timetable.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    private ClientService service;

   /* @GetMapping("/{id}")
    public Client getId(@PathVariable int id){return service.getId(id);}*/

}
