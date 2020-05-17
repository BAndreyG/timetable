package com.timetable.raspisaniye_timetable.service;

import com.timetable.raspisaniye_timetable.model.Client;
import com.timetable.raspisaniye_timetable.model.History;
import com.timetable.raspisaniye_timetable.repo.ClientRepo;
import com.timetable.raspisaniye_timetable.repo.HistoryRepo;
import com.timetable.raspisaniye_timetable.to.ClientTo;
import com.timetable.raspisaniye_timetable.util.ClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientService {

    @Autowired
    private ClientRepo repo;

    public ClientTo getId(int id){
        if (repo.existsById(id)) {
            return ClientUtil.toClientTo(repo.findById(id),new ClientTo());
        }else return null;
    }

    public List<Client> getAll() {
        return repo.findAll(Sort.by("name"));
    }

}
