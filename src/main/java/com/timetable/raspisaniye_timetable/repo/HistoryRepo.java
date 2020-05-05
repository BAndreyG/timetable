package com.timetable.raspisaniye_timetable.repo;

import com.timetable.raspisaniye_timetable.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepo extends JpaRepository<History,Integer> {
    History findById(int id);
}
