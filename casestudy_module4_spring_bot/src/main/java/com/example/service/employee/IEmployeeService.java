package com.example.service.employee;

import com.example.model.customer.Customer;
import com.example.model.employee.Employee;

import java.util.List;


public interface IEmployeeService {
    List<Employee> findAllEmployee();
}
