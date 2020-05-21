package com.timetable.raspisaniye_timetable.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "clients")
@NoArgsConstructor
public class Client extends AbstractBaseEntity {

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

    @Column(name = "registered", nullable = false, columnDefinition = "timestamp default now()")
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime registered;

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "tel")
    private int tel;

    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")//, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @OrderBy("dateTime DESC")
//    @JsonIgnore
    protected List<Meal> meals;*/
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
    @OneToMany( mappedBy = "client")
    @JsonBackReference
//    @JsonIgnore
    protected List<History> histories;

}
