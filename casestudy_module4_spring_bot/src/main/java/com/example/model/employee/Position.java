package com.example.model.employee;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "vi_tri")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_vi_tri")
    private int id;

    @Column(name = "ten_vi_tri")
    private String name;

    @OneToMany(mappedBy = "position")
    private Set<Employee> employees;

    public Position() {
    }

    public Position(int id, String name) {
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

