package com.example.model.employee;

import com.example.model.contract.Contract;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "nhan_vien")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_nhan_vien")
    private int id;

    @Column(name = "ho_ten")
    private String name;
    @Column(name = "ngay_sinh")
    private String dateOfBirth;
    @Column(name = "so_cmnd")
    private String idCard;
    @Column(name = "luong")
    private double salary;
    @Column(name = "so_dien_thoai")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "dia_chi")
    private String address;

    private int status;

    @ManyToOne
    @JoinColumn(name = "ma_vi_tri", referencedColumnName = "ma_vi_tri")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "ma_trinh_do", referencedColumnName = "ma_trinh_do")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "ma_bo_phan", referencedColumnName = "ma_bo_phan")
    private Division division;

    @OneToMany(mappedBy = "employee")
    private Set<Contract> contract;

    public Employee() {
    }

    public Employee(int id, String name, String dateOfBirth, String idCard, double salary, String phoneNumber, String email, String address, int status) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.status = status;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Set<Contract> getContract() {
        return contract;
    }

    public void setContract(Set<Contract> contract) {
        this.contract = contract;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

