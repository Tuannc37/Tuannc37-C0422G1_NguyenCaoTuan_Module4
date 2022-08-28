package com.example.controller;

import com.example.model.customer.Customer;
import com.example.service.customer.ICustomerService;
import com.example.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping(value = {"customer",})
    public String showList(Model model, @PageableDefault(page = 0, size = 5) Pageable pageable,
                           @RequestParam Optional<String> name) {
        String nameVal = name.orElse("");
        model.addAttribute("customers", iCustomerService.findCustomerAll(nameVal,pageable));
        model.addAttribute("nameVal", nameVal);
        return "customer/customer_list";
    }

    @GetMapping("showCreateCustomer")
    public String showCreateCustomer(Model model){
        model.addAttribute("customer",new Customer());
        model.addAttribute("customerTypeList",iCustomerTypeService.findAll());
        return "customer/customer_create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
        iCustomerService.create(customer);
        redirectAttributes.addFlashAttribute("mess","Thêm mơi thành công!");
        return "redirect:/customer";
    }

    @GetMapping("showEditCustomer/{id}")
    public String showEditCustomer(@PathVariable int id, Model model) {
        model.addAttribute("customerTypeList",iCustomerTypeService.findAll());
        model.addAttribute("customer", iCustomerService.findById(id));
        return "customer/customer_edit";
    }

    @PostMapping("edit/{id}")
    public String edit(@ModelAttribute("customer") Customer customer,RedirectAttributes redirectAttributes) {
        iCustomerService.update(customer);
        redirectAttributes.addFlashAttribute("mess", "Sửa thành công!");
        return "redirect:/customer";
    }

    @PostMapping("delete")
    public String delete(@RequestParam int id,
                         RedirectAttributes redirectAttributes) {
        iCustomerService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công!");
        return "redirect:/customer";
    }
}
