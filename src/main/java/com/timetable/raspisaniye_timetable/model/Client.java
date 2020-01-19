package com.timetable.raspisaniye_timetable.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.xml.crypto.Data;

@Entity
@Table(name="clients")
public class Client extends AbstractBaseEntity{

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "name")
    private String name;
    private String adres;
    private boolean enabled;
    private Data registered;
    private int tel;
    private String description;

    @ManyToOne
    private User user;


}
