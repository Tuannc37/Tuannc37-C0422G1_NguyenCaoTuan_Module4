package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.service.ISpiceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ChooseController {

    @Autowired
    private ISpiceService iSpiceService;

    @GetMapping("/")
    public String home(Model model) {
        List<String> strings = this.iSpiceService.findAll();
        model.addAttribute("menu", strings);
        return "index";
    }

    @PostMapping("/save")
    public String save(@RequestParam (required = false)List<String> stringList, ModelMap model) {
        if(stringList == null){
            model.addAttribute("list","File not found");
        }
        if(stringList != null){
            model.addAttribute("list", stringList);
        }
        return "index";
    }
}
