package com.timetable.raspisaniye_timetable.service;

import com.timetable.raspisaniye_timetable.model.History;
import com.timetable.raspisaniye_timetable.repo.HistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepo repo;

    public History getId(int id){
        return repo.findById(id);
    }
}
