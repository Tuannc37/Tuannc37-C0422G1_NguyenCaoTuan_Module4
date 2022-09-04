package com.example.service.facility.impl;

import com.example.model.facility.Facility;
import com.example.repository.facilyti.IFacilityRepository;
import com.example.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityRepository iFacilityRepository;


    @Override
    public Page<Facility> findFacilityAll(String name, Pageable pageable) {
        return iFacilityRepository.findByNameContaining(name,pageable);
    }

    @Override
    public Optional<Facility> findByFacilityId(int id) {
        return iFacilityRepository.findById(id);
    }

    @Override
    public void create(Facility facility) {
        iFacilityRepository.save(facility);
    }

    @Override
    public void delete(int id) {
        iFacilityRepository.deleteById(id);
    }

    @Override
    public void update(Facility facility) {
        iFacilityRepository.save(facility);
    }
}
