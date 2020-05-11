package com.timetable.raspisaniye_timetable.repo;

import com.timetable.raspisaniye_timetable.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface HistoryRepo extends JpaRepository<History,Integer> {
    History findById(int id);

    List<History> findAllByDateBetweenOrderByDate(LocalDateTime start, LocalDateTime end);
}
