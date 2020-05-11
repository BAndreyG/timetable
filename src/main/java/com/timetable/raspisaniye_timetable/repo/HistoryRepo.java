package com.timetable.raspisaniye_timetable.repo;

import com.timetable.raspisaniye_timetable.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface HistoryRepo extends JpaRepository<History,Integer> {
    History findById(int id);

    List<History> findAllByDateBetweenOrderByDate(LocalDateTime start, LocalDateTime end);

    @Query("SELECT h FROM History h where h.client.id=:client_id ORDER BY h.date")
    List<History> findAllHistoryByClientId(@Param("client_id") int client_id);

    /*@Query("SELECT m FROM Meal m WHERE m.user.id=:userId ORDER BY m.dateTime DESC")
    List<Meal> getAll(@Param("userId") int userId);*/

}
