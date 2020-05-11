package com.timetable.raspisaniye_timetable;

import com.timetable.raspisaniye_timetable.service.ClientService;
import com.timetable.raspisaniye_timetable.util.WeekDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class RaspisaniyeTimetableApplication {

	public static void main(String[] args) {
		SpringApplication.run(RaspisaniyeTimetableApplication.class, args);
	}

}
