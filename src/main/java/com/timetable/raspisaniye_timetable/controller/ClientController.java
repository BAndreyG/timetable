package com.timetable.raspisaniye_timetable.controller;

import com.timetable.raspisaniye_timetable.model.Client;
import com.timetable.raspisaniye_timetable.model.History;
import com.timetable.raspisaniye_timetable.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = ClientController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {

    static final String REST_URL = "/client";
    protected final Logger log = LoggerFactory.getLogger(getClass());


    @Autowired
    private ClientService service;

    @GetMapping("/{id}")
    public Client getId(@PathVariable int id) {
        Client c=service.getId(id);
        System.out.println(c.toString());
        return c;
    }

    @GetMapping
    public List<Client> getAll() {
        log.info("get all Client");
        return service.getAll();
    }

    @GetMapping("/history/{clientid}")
    public List<History> getClientId(@PathVariable int clientid) {
        return service.findAllHistoryByClientId(clientid);
    }
}
