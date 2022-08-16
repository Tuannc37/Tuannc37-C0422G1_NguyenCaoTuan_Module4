package com.example.controller;
import com.example.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class ConvertController {
    @Autowired
    private IConvertService convertService;

    @GetMapping("/")
    public String greeting(){
        return "/home";
    }

    @GetMapping("/convert")
    public String convert(@RequestParam float usd, Model model){
        float result = convertService.convert(usd);
        model.addAttribute("usd",usd);
        model.addAttribute("result", result);
        return "/home";
    }
}
