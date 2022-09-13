package com.example.model.contract;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name= "dich_vu_di_kem")
public class AttachFacility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_dich_vu_di_kem")
    private Integer id;

    @Column(name = "ten_dich_vu_di_kem")
    private String name;
    @Column(name = "gia")
    private Double cost;
    @Column(name = "don_vi")
    private String unit;
    @Column(name = "trang_thai")
    private String status;

    @OneToMany(mappedBy = "attachFacility")
    @JsonBackReference
    private Set<ContractDetail> contactDetails;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<ContractDetail> getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(Set<ContractDetail> contactDetails) {
        this.contactDetails = contactDetails;
    }
}
