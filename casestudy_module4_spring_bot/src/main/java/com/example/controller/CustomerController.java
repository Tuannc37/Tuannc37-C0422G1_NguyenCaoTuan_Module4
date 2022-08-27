package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
    @GetMapping("/customer")
    public String testCustomer(){
        return "customer/customer_list";
    }

    @GetMapping("/showEditCustomer")
    public String showEditCustomer(){
        return "customer/customer_edit";
    }

    @GetMapping("/showCreateCustomer")
    public String showCreateCustomer(){
        return "customer/customer_create";
    }


}
