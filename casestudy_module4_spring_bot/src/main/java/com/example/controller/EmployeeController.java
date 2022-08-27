package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {
    @GetMapping("/employee")
    public String testEmployee(){
        return "employee/employee_list";
    }

    @GetMapping("/showEditEmployee")
    public String showEditEmployee(){
        return "employee/employee_edit";
    }

    @GetMapping("/showCreateEmployee")
    public String showCreateEmployee(){
        return "employee/employee_create";
    }
}
