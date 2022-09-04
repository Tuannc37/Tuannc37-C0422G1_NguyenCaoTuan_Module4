package com.example.service.facility.impl;

import com.example.model.facility.RentType;
import com.example.repository.facilyti.IRentTypeRepository;
import com.example.service.facility.IRenTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RenTypeSerrvice implements IRenTypeService {
    @Autowired
    private  IRentTypeRepository iRentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return iRentTypeRepository.findAll();
    }
}
