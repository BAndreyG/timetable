package com.timetable.raspisaniye_timetable.service;

import com.timetable.raspisaniye_timetable.model.Client;
import com.timetable.raspisaniye_timetable.repo.ClientRepo;
import com.timetable.raspisaniye_timetable.to.ClientTo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ClientServiceTest {

    @Autowired
    private ClientService service;

    @MockBean
    private ClientRepo repo;

    @Test
    void getId() {
        ClientTo result = service.getId(100003);
        ClientTo clientNull = service.getId(1);
        Mockito.verify(repo, Mockito.times(1)).existsById(100003);
        Mockito.verify(repo, Mockito.times(1)).existsById(1);
        Mockito.doReturn(new Client())
                .when(repo)
                .findById(100003);
    }

    @Test
    void getAll() {
        List<Client> result = service.getAll();
        Mockito.verify(repo, Mockito.times(1)).findAll(Sort.by("name"));
    }
}