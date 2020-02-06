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

    @PostMapping
    public String names(@RequestParam(value="name") String[] nameArray){
        //TODO
        System.out.println(nameArray);
        return nameArray.toString();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAll(Model model, HttpServletRequest request) {
        log.info("getALL {} Busytime");
        model.addAttribute("busytime",service.getAll());
        return "/";
    }
}
