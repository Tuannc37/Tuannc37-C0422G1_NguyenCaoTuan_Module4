package com.service.impl;

import com.model.Province;
import com.repository.IProvinceRepository;
import com.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvinceService implements IProvinceService {
    @Autowired
    private IProvinceRepository iProvinceRepository;

    @Override
    public List<Province> findAll() {
        return iProvinceRepository.findAll();
    }

    @Override
    public void update(Province province) {
        iProvinceRepository.save(province);
    }

    @Override
    public void delete(long id) {
        iProvinceRepository.deleteById(id);
    }

    @Override
    public void save(Province province) {
        iProvinceRepository.save(province);
    }

    @Override
    public Optional<Province> findId(long id) {
        return iProvinceRepository.findById(id);
    }
}