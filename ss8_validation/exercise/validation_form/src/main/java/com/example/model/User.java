package com.example.model;

import javax.persistence.*;

@Entity
@Table(name =  "form_input")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastName;
    private String tel;
    private int age;
    private String email;

    public User() {
    }

    public User(Integer id, String firstname, String lastName, String tel, int age, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastName = lastName;
        this.tel = tel;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
