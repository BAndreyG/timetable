package com.timetable.raspisaniye_timetable.service;

import com.timetable.raspisaniye_timetable.model.Client;
import com.timetable.raspisaniye_timetable.repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepo repo;

    public Client getId(int id){
        if (repo.existsById(id)) {
            System.out.println(repo.findById(id));
            return repo.findById(id);
        }else return null;
    }
}
