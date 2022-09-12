package com.example.model.contract;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name= "hop_dong_chi_tiet")
public class ContractDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_hop_dong_chi_tiet")
    private Integer id;

    @Column(name = "so_luong")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "ma_dich_vu_di_kem", referencedColumnName = "ma_dich_vu_di_kem")
    private AttachFacility attachFacility;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "ma_hop_dong", referencedColumnName = "ma_hop_dong")
    private Contract contract;

    public ContractDetail() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
