package com.example.service;

import com.example.model.SmartPhone;

import java.util.Optional;

public interface ISmartPhoneService {
    Iterable<SmartPhone> findAll();

    Optional<SmartPhone> findById(Integer id);

    void save(SmartPhone smartPhone);

    void remove(Integer id);

    void update(SmartPhone smartPhone);
}
