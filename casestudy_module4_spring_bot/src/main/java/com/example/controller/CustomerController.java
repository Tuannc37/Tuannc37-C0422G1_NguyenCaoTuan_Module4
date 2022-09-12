package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.model.customer.Customer;
import com.example.service.customer.ICustomerService;
import com.example.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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
        model.addAttribute("customerDto",new CustomerDto());
        model.addAttribute("customerTypeList",iCustomerTypeService.findAll());
        return "customer/customer_create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute @Valid CustomerDto customerDto, BindingResult
            bindingResult, RedirectAttributes redirectAttributes,Model model){
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypeList",iCustomerTypeService.findAll());
            return "customer/customer_create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        iCustomerService.create(customer);
        redirectAttributes.addFlashAttribute("mess","Thêm mơi thành công!");
        return "redirect:/customer";
    }

    @GetMapping("showEditCustomer/{id}")
    public String showEditCustomer(@PathVariable int id, Model model) {
        model.addAttribute("customerTypeList",iCustomerTypeService.findAll());
        model.addAttribute("customerDto", iCustomerService.findById(id));
        return "customer/customer_edit";
    }

    @PostMapping("edit")
    public String edit(@ModelAttribute @Valid CustomerDto customerDto, BindingResult
            bindingResult, RedirectAttributes redirectAttributes,Model model) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypeList",iCustomerTypeService.findAll());
            return "customer/customer_edit";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        iCustomerService.update(customer);
        redirectAttributes.addFlashAttribute("mess","Cập nhật thành công!");
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
