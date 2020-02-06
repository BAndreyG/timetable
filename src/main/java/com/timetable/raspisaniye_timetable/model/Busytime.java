package com.timetable.raspisaniye_timetable.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "busytimes")
public class Busytime extends AbstractBaseEntity {

    @Column(name = "registered",nullable = false,columnDefinition = "timestamp default now()", insertable = false, updatable =false)
    @NotNull
    private Date registered;

    @Column(name = "timed")
    private Time timed;

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "days")
    private String days;

    public Busytime(){}

    public Busytime(Integer id, @NotNull Date registered, Time timed, @NotBlank @Size(min = 2, max = 100) String days) {
        super(id);
        this.registered = registered;
        this.timed = timed;
        this.days = days;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public Time getTimed() {
        return timed;
    }

    public void setTimed(Time timed) {
        this.timed = timed;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }
}
