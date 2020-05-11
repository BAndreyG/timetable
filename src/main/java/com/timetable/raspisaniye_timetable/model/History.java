package com.timetable.raspisaniye_timetable.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "historys")
public class History extends AbstractBaseEntity {

    /*@NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "name")
    private String name;*/

    @NotBlank
    @Column(name = "date")
    private LocalDateTime date;

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "description")
    private String description;

    @Column(name = "registered",nullable = false,columnDefinition = "timestamp default now()")
    @NotNull
    private LocalDateTime registered;

/*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;
*/

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
    @NotNull
    private Client client;
    public History(){}
}
