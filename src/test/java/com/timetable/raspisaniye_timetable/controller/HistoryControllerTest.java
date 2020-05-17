package com.timetable.raspisaniye_timetable.controller;

import com.timetable.raspisaniye_timetable.model.History;
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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@Transactional
@TestPropertySource("/application-test.properties")
@Sql(value = {"/before-test-data.sql"},executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/after-test-data.sql"},executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class HistoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HistoryController historyController;

    @Test
    void getAll()  throws Exception{
        List<History> list=historyController.getAll();
        assertNotNull(list);
        assertEquals(list.get(0).getClass(),History.class);
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/history")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getHisId() throws Exception{
        assertNotNull(historyController.getHisId(100008));
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/history/100008")
                .accept(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
//                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void getClientId()throws Exception {
        assertNotNull(historyController.getClientId(100003));
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/history/client/100003")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}