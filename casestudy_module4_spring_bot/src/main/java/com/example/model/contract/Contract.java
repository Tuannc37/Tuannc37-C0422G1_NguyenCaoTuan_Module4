package com.example.model.contract;

import com.example.model.customer.Customer;
import com.example.model.employee.Employee;
import com.example.model.facility.Facility;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name= "hop_dong")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_hop_dong")
    private int id;

    @Column(name = "ngay_lam_hop_dong")
    private Date startDate;
    @Column(name = "ngay_ket_thuc")
    private Date endDate;
    @Column(name = "tien_dat_coc")
    private Double deposit;
    private transient Double totalMoney;

    @ManyToOne
    @JoinColumn(name = "ma_nhan_vien", referencedColumnName = "ma_nhan_vien")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "ma_khach_hang", referencedColumnName = "ma_khach_hang")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "ma_dich_vu", referencedColumnName = "ma_dich_vu")
    private Facility facility;

    @OneToMany(mappedBy = "contract")
    private Set<ContractDetail> contractDetails;

    public Contract() {
    }

    public Contract(int id) {
        this.id = id;
    }

    public Contract(int id, Date startDate, Date endDate, double deposit, Employee employee, Customer customer, Facility facility, Set<ContractDetail> contractDetails) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;
        this.contractDetails = contractDetails;
    }

    public Contract(int id, Date startDate, Date endDate, Double deposit, Double totalMoney, Employee employee, Customer customer, Facility facility, Set<ContractDetail> contractDetails) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;
        this.contractDetails = contractDetails;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getDeposit() {
        return deposit;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}

