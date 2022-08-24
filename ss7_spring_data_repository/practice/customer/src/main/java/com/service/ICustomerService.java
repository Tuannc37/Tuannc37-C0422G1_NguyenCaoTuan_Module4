package com.service;

import com.model.Customer;
import com.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService{
    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);

    public Page<Customer> findAll(Pageable pageable);

    void update(Customer customer);

    void delete(long id);

    void save(Customer customer);

    Optional<Customer> findId(long id);

    Iterable<Customer> findAllByProvince(Province province);
}
