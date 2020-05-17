package com.timetable.raspisaniye_timetable.service;

import com.timetable.raspisaniye_timetable.model.Client;
import com.timetable.raspisaniye_timetable.model.History;
import com.timetable.raspisaniye_timetable.repo.HistoryRepo;
import com.timetable.raspisaniye_timetable.util.WeekDate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class HistoryServiceTest {

    @Autowired
    private HistoryService service;

    @MockBean
    private HistoryRepo repo;

    @Test
    void getId() {
        History h=service.getId(100009);
        Mockito.verify(repo,Mockito.times(1)).existsById(100009);
        Mockito.doReturn(new History())
                .when(repo)
                .findById(100009);
    }

    @Test
    void getAllClientWeek() {
        LocalDate[] listDate= WeekDate.getWeekDate(LocalDate.now());
        service.getAllClientWeek(LocalDate.now());
        Mockito.verify(repo,Mockito.times(1))
                .findAllByDateBetweenOrderByDate(listDate[0].atStartOfDay(),listDate[1].atStartOfDay());
    }

    @Test
    void getAll() {
        service.getAll();
        Mockito.verify(repo,Mockito.times(1)).findAll();
    }

    @Test
    void findAllHistoryByClientId() {
        service.findAllHistoryByClientId(100003);
        Mockito.verify(repo,Mockito.times(1)).findAllHistoryByClientId(100003);
    }
}