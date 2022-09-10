package com.example.model.employee;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "trinh_do")
public class EducationDegree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_trinh_do")
    private int id;

    @Column(name = "ten_trinh_do")
    private String name;

    @OneToMany(mappedBy = "educationDegree")
    private Set<Employee> employees;

    public EducationDegree() {
    }

    public EducationDegree(int id, String name) {
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
