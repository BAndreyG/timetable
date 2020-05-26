package com.timetable.raspisaniye_timetable.controller;

import com.timetable.raspisaniye_timetable.model.History;
import com.timetable.raspisaniye_timetable.service.HistoryService;
import com.timetable.raspisaniye_timetable.to.HistoryTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = HistoryController.REST_URL,produces = MediaType.APPLICATION_JSON_VALUE)
public class HistoryController {

    @Autowired
    private HistoryService service;

    static final String REST_URL = "/history";
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping
    public List<History> getAll() {
        log.info("get all history");
        return service.getAll();
    }

    @GetMapping("/test")
    public List<HistoryTo> getAllWeek() {
        log.info("get all history on this week");
        return service.getAllClientWeek(LocalDate.now());
    }

    @GetMapping("/{id}")
    public History getHisId(@PathVariable int id){return service.getId(id);}

    @GetMapping("/client/{clientid}")
    public List<History> getClientId(@PathVariable int clientid) {
        return service.findAllHistoryByClientId(clientid);
    }
}
