package com.timetable.raspisaniye_timetable.controller;

import com.timetable.raspisaniye_timetable.model.History;
import com.timetable.raspisaniye_timetable.service.HistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = HistoryController.REST_URL,produces = MediaType.APPLICATION_JSON_VALUE)
public class HistoryController {

    static final String REST_URL = "/history";
    protected final Logger log = LoggerFactory.getLogger(getClass());


    @Autowired
    private HistoryService service;

    @GetMapping("/{id}")
    public History getHisId(@PathVariable int id){return service.getId(id);}
}
