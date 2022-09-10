package com.example.model.contract;

import javax.persistence.*;

@Entity
@Table(name= "hop_dong_chi_tiet")
public class ContractDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_hop_dong_chi_tiet")
    private int id;

    @Column(name = "so_luong")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "ma_dich_vu_di_kem", referencedColumnName = "ma_dich_vu_di_kem")
    private AttachFacility attachFacility;

    @ManyToOne
    @JoinColumn(name = "ma_hop_dong", referencedColumnName = "ma_hop_dong")
    private Contract contract;

    public ContractDetail() {
    }

    public ContractDetail(int id, int quantity, AttachFacility attachFacility, Contract contract) {
        this.id = id;
        this.quantity = quantity;
        this.attachFacility = attachFacility;
        this.contract = contract;
    }

    public ContractDetail(int quantity, AttachFacility attachFacility, Contract contract) {
        this.quantity = quantity;
        this.attachFacility = attachFacility;
        this.contract = contract;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
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
