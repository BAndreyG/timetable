package com.timetable.raspisaniye_timetable.repo;

import com.timetable.raspisaniye_timetable.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<Client,Integer> {
    Client findById(int id);
}
