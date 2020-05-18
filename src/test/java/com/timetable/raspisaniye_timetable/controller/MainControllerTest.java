package com.timetable.raspisaniye_timetable.controller;

import com.timetable.raspisaniye_timetable.model.History;
import com.timetable.raspisaniye_timetable.service.HistoryService;
import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@Transactional
@TestPropertySource("/application-test.properties")
@Sql(value = {"/before-test-data.sql"},executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/after-test-data.sql"},executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HistoryService historyService;

    @Test
    void getAllClientWeek() throws Exception{
        //TODO https://overcoder.net/q/49514/junit-5-%D0%BA%D0%B0%D0%BA-%D1%83%D1%82%D0%B2%D0%B5%D1%80%D0%B6%D0%B4%D0%B0%D1%82%D1%8C-%D0%B8%D1%81%D0%BA%D0%BB%D1%8E%D1%87%D0%B5%D0%BD%D0%B8%D0%B5-%D0%B1%D1%80%D0%BE%D1%88%D0%B5%D0%BD%D0%BE
        //TODO перехват ожидаемой ошибки
//
      /*  assertThrows(StackOverflowError.class, (Executable) this.mockMvc.perform(MockMvcRequestBuilders
                .get("/")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.model()
                        .attribute("history","history")) //,historyService.getAllClientWeek(LocalDate.now().plusDays(7)).get(0).getDate().getHour())
                .andExpect(status().isOk()));*/
        /*this.mockMvc.perform(MockMvcRequestBuilders
                    .get("/")
                    .accept(MediaType.APPLICATION_JSON_VALUE))
                    .andDo(print())
                    .andExpect(MockMvcResultMatchers.model()
                            .attribute("history","history")) //,historyService.getAllClientWeek(LocalDate.now().plusDays(7)).get(0).getDate().getHour())
                    .andExpect(status().isOk());*/
    }

    @Test
    void getAllClientNextWeek() {
    }

    @Test
    void getAllClientLastWeek() {
    }

    @Test
    void handleAllExceptions() {
    }
}