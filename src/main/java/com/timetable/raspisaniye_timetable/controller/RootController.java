package com.timetable.raspisaniye_timetable.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @PostMapping
    public String names(@RequestParam(value="name") String[] nameArray){
        //TODO
        System.out.println(nameArray);
        return nameArray.toString();
    }
}
