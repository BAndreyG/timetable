package com.timetable.raspisaniye_timetable.service;

import com.timetable.raspisaniye_timetable.model.History;
import com.timetable.raspisaniye_timetable.repo.HistoryRepo;
import com.timetable.raspisaniye_timetable.util.WeekDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class HistoryService {

    @Autowired
    private HistoryRepo repo;

    public History getId(int id)
    {
        if (repo.existsById(id)) return repo.findById(id);
        else return null;
    }

//    public History getClientId(int id){
//        return repo.findById(id);
//    }

    public List<History> getAllClientWeek(LocalDate date) {
        LocalDate[] listDate=WeekDate.getWeekDate(date);
        List<History> list=repo.findAllByDateBetweenOrderByDate(listDate[0].atStartOfDay(),listDate[1].atStartOfDay());

        return list;
    }

    public List<History> getAll() {
        return repo.findAll();
    }

    public List<History> findAllHistoryByClientId(int clientid) {
        return repo.findAllHistoryByClientId(clientid);
    }
}
