package com.example.controller;

import com.example.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SmartPhoneController {
    @Autowired
    private ISmartPhoneService smartPhoneService;

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("smartphones", smartPhoneService.findAll());
        return "list";
    }
}

