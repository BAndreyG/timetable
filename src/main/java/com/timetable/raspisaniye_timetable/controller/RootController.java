package com.timetable.raspisaniye_timetable.controller;

import com.timetable.raspisaniye_timetable.model.Busytime;
import com.timetable.raspisaniye_timetable.service.BusytimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
//@PreAuthorize("hasRole('ADMIN')|| hasRole('USER')")
@RequestMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
public class RootController {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private BusytimeService service;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String seveAll(Model model, HttpServletRequest request) {
        log.info("saveALL {} POST");

        return "/";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAll(Model model) {

        List<Busytime> list=service.getAll();
        Busytime bt=list.get(1);
        model.addAttribute("busytime",bt);//service.getAll()
        log.info("getALL {} Busytime",bt);
        return "/";
    }
}
