package com.timetable.raspisaniye_timetable.controller;

import com.timetable.raspisaniye_timetable.model.Client;
import com.timetable.raspisaniye_timetable.model.History;
import com.timetable.raspisaniye_timetable.service.ClientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@Transactional
@TestPropertySource("/application-test.properties")
@Sql(value = {"/before-test-data.sql"},executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/after-test-data.sql"},executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClientService clientService;
    @Test
    void getId()throws Exception {
        assertNotNull(clientService.getId(100003));
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/client/100003")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getAll() throws Exception{
        List<Client> list=clientService.getAll();
        assertNotNull(list);
        assertEquals(list.get(0).getClass(),Client.class);
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/client")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}