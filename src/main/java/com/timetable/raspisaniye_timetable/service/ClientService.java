package com.timetable.raspisaniye_timetable.service;

import com.timetable.raspisaniye_timetable.model.Client;
import com.timetable.raspisaniye_timetable.repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Client> getAll() {
        return repo.findAll(Sort.by("name"));
    }
}
