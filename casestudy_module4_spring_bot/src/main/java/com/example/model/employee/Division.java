package com.example.model.employee;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "bo_phan")
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_bo_phan")
    private int id;

    @Column(name = "ten_bo_phan")
    private String name;

    @OneToMany(mappedBy = "division")
    private Set<Employee> employees;

    public Division() {
    }

    public Division(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}

