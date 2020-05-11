package com.timetable.raspisaniye_timetable.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
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

    @Column(name = "registered",nullable = false,columnDefinition = "timestamp default now()")
    @NotNull
    private LocalDateTime registered;

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "tel")
    private int tel;

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "description")
    private String description;

    /*@ManyToOne
    private User user;*/
//    @OneToMany(cascade = CascadeType.ALL)
/*    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name  = "client")
    @OrderBy("registered ASC")
    protected List<History> history;*/

    public Client(){}

}
