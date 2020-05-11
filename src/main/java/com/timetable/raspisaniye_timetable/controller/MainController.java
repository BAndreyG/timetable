package com.timetable.raspisaniye_timetable.controller;

import com.timetable.raspisaniye_timetable.model.History;
import com.timetable.raspisaniye_timetable.service.ClientService;
import com.timetable.raspisaniye_timetable.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private HistoryService historyService;

    @GetMapping(value = "/")
    public String getAllClientWeek(Model model){
        List<History> list=historyService.getAllClientWeek();
        model.addAttribute("start",list.get(0).getDate().getHour());
        model.addAttribute("end",list.get(list.size()-1).getDate().getHour());
        model.addAttribute("history",list);
        return "index";
    }
}
