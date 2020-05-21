package com.timetable.raspisaniye_timetable.controller;

import com.timetable.raspisaniye_timetable.model.Client;
import com.timetable.raspisaniye_timetable.model.History;
import com.timetable.raspisaniye_timetable.service.ClientService;
import com.timetable.raspisaniye_timetable.to.ClientTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ClientController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {

    static final String REST_URL = "/client";
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ClientService service;

    @GetMapping("/{id}")
    public ClientTo getId(@PathVariable int id) {
        log.info("get Client by id"+id);
        return service.getId(id);
    }

    @GetMapping
    public List<Client> getAll() {
        log.info("get all Client");
        return service.getAll();
    }

    @PostMapping
    public Client create(@RequestBody Client client){
        return service.save(client);
    }

    @PutMapping
    public Client update(@PathVariable("id") Client clientToDb,@RequestBody Client client){
        BeanUtils.copyProperties(client,clientToDb,"id");
        return service.save(clientToDb);
    }
}
