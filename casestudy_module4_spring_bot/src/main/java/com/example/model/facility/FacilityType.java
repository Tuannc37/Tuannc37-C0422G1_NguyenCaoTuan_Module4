package com.example.model.facility;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "loai_dich_vu")
public class FacilityType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_loai_dich_vu")
    private int id;
    @Column(name = "ten_loai_dich_vu")
    private String name;

    @OneToMany(mappedBy = "facilityType")
    private Set<Facility> facilities;

    public FacilityType() {
    }

    public FacilityType(int id, String name) {
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
