package com.timetable.raspisaniye_timetable.service;

import com.timetable.raspisaniye_timetable.model.Busytime;
import com.timetable.raspisaniye_timetable.repository.BusytimeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BusytimeService {

    private final BusytimeRepo repo;

    @Autowired
    public BusytimeService(BusytimeRepo repo) {
        this.repo = repo;
    }

    public List<Busytime> getAll() {
        return repo.findAll();
    }
}
