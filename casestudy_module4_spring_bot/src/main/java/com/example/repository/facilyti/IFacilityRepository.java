package com.example.repository.facilyti;

import com.example.model.facility.Facility;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;



@Transactional
public interface IFacilityRepository extends JpaRepository<Facility,Integer> {
    Page<Facility> findByNameContaining(String name, Pageable pageable);
}
