package com.example.model.facility;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "kieu_thue")
public class RentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_kieu_thue")
    private int id;
    @Column(name = "ten_kieu_thue")
    private String name;

    @OneToMany(mappedBy = "rentType")
    private Set<Facility> facilities;

    public RentType() {
    }

    public RentType(int id, String name) {
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

    public Set<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(Set<Facility> facilities) {
        this.facilities = facilities;
    }
}
