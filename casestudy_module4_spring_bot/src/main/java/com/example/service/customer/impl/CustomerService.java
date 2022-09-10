package com.example.service.customer.impl;

import com.example.model.customer.Customer;
import com.example.repository.customer.ICustomerRepository;
import com.example.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findCustomerAll(String name, Pageable pageable) {
        return iCustomerRepository.findByNameContaining(name,pageable);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(int id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void create(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void delete(int id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public void update(Customer customer) {
        iCustomerRepository.save(customer);
    }
}
