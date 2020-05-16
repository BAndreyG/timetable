package com.timetable.raspisaniye_timetable.controller;

import com.timetable.raspisaniye_timetable.model.History;
import com.timetable.raspisaniye_timetable.service.ClientService;
import com.timetable.raspisaniye_timetable.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private HistoryService historyService;

    @GetMapping(value = "/")
    public String getAllClientWeek(Model model){
        List<History> list=historyService.getAllClientWeek(LocalDate.now());
        model.addAttribute("start",list.get(0).getDate().getHour());
        model.addAttribute("end",list.get(list.size()-1).getDate().getHour());
        model.addAttribute("history",list);
        return "index";
    }

    @GetMapping(value = "/next")
    public String getAllClientNextWeek(Model model){
        List<History> list=historyService.getAllClientWeek(LocalDate.now().plusDays(7));
        model.addAttribute("start",list.get(0).getDate().getHour());
        model.addAttribute("end",list.get(list.size()-1).getDate().getHour());
        model.addAttribute("history",list);
        return "index";
    }
    @GetMapping(value = "/last")
    public String getAllClientLastWeek(Model model){
        List<History> list=historyService.getAllClientWeek(LocalDate.now().minusDays(7));
        model.addAttribute("start",list.get(0).getDate().getHour());
        model.addAttribute("end",list.get(list.size()-1).getDate().getHour());
        model.addAttribute("history",list);
        return "index";
    }

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<Exception> handleAllExceptions(RuntimeException ex) {
        return new ResponseEntity<Exception>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
