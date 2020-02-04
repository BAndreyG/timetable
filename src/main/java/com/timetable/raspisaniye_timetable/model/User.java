package com.timetable.raspisaniye_timetable.model;

import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends AbstractBaseEntity {

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "name")
    private String name;

    @Column(name = "password")
    @Size(min = 8, max = 250)
    private String password;

    @Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
    private boolean enabled = true;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    @BatchSize(size = 200)
    private Set<Role> roles;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Client> client;

    public User() {
    }

    public User(User u) {
        this(u.getId(), u.getName(), u.getPassword(), u.isEnabled(), u.getRoles());
    }

    public User(Integer id, String name,  String password, Role role, Role... roles) {
        this(id, name,  password, true, EnumSet.of(role, roles));
    }

    public User(@Size(min = 8, max = 250) String password, boolean enabled, Set<Role> roles) {
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;

    }

   /* public User(Integer id, String name, String email, @Size(min = 8, max = 250) String password, boolean enabled, Set<Role> roles) {
        super(id);
        this.name = name;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
    }*/

    public User(Integer id, String name, String password, boolean enabled, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
    }

    public User(Integer integer, String name, String toLowerCase, String password, Role roleUser) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password=XXX'" +
                ", enabled=" + enabled +
                ", roles=" + roles +
                ", id=" + id +
                '}';
    }
}
