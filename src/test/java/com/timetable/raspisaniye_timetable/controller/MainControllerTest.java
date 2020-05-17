package com.timetable.raspisaniye_timetable.controller;

import com.timetable.raspisaniye_timetable.model.History;
import com.timetable.raspisaniye_timetable.service.HistoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
        this.mockMvc.perform(MockMvcRequestBuilders
                    .get("/")
                    .accept(MediaType.APPLICATION_JSON_VALUE))
                    .andDo(print())
                    .andExpect(MockMvcResultMatchers.model()
                            .attribute("start",historyService.getAllClientWeek(LocalDate.now().plusDays(7)).get(0).getDate().getHour()))
                    .andExpect(status().isOk());
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