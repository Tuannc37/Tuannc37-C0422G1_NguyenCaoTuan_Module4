package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HelloWorld {

    @GetMapping("/")
    public String greeting(){
        return "/greeting";
    }
}
