package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FaccilityController {

    @GetMapping("/facility")
    public String testFacility(){
        return "facility/facility_list";
    }

    @GetMapping("/showEditFacility")
    public String showEditFacility(){
        return "facility/facility_edit";
    }

    @GetMapping("/showCreateFacility")
    public String showCreateFacility(){
        return "facility/facility_create";
    }
}
