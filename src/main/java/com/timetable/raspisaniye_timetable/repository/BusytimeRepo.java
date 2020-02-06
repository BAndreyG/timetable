package com.timetable.raspisaniye_timetable.repository;

import com.timetable.raspisaniye_timetable.model.Busytime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusytimeRepo extends JpaRepository<Busytime,Integer> {
}
