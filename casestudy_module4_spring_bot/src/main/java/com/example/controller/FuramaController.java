package com.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FuramaController {

    @GetMapping("/")
    public String test(){
        return "include/home";
    }

}
