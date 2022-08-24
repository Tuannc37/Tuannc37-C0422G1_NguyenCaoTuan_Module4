package com.service;

import com.model.Customer;
import com.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProvinceService{
    List<Province> findAll();

    void update(Province province);

    void delete(long id);

    void save(Province province);

    Optional<Province> findId(long id);
}
