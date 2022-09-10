package com.example.service.customer;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findCustomerAll(String name, Pageable pageable);

    List<Customer> findAllCustomer();

    Optional<Customer> findById(int id);

    void create(Customer customer);

    void delete(int id);

    void update(Customer customer);
}
