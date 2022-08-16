package com.controller;

import com.service.ICaculatorSerrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @Autowired
    private ICaculatorSerrvice iCaculatorSerrvice;

    @GetMapping("/")
    public String showCalculator() {
        return "caculator";
    }

    @PostMapping("/calculator")
    public String calculate(@RequestParam int number1, @RequestParam int number2, @RequestParam char operator,
                            Model model) {
        Float result = iCaculatorSerrvice.calculate(number1,number2,operator);
        model.addAttribute("result",result);
        model.addAttribute("number1",number1);
        model.addAttribute("number2",number2);
        model.addAttribute("operator",operator);
        return "caculator";
    }
}
