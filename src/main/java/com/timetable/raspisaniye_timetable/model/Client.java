package com.timetable.raspisaniye_timetable.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@Table(name="clients")
public class Client extends AbstractBaseEntity{

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "name")
    private String name;

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "adres")
    private String adres;

    @Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
    private boolean enabled = true;

    @Column(name = "registered",nullable = false,columnDefinition = "timestamp default now()", insertable = false, updatable =false)
    @NotNull
    private Date registered;

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "tel")
    private int tel;

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "description")
    private String description;

    @ManyToOne
    private User user;


}
