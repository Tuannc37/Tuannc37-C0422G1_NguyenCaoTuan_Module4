package com.controller;

import com.model.Declaration;
import com.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("person")
public class DeclarationController {
    @Autowired
    private IDeclarationService declarationService;

    @GetMapping("list")
    public String showList(Model model) {
        model.addAttribute("personList", declarationService.findAll());
        return "list";
    }

    @GetMapping("showCreate")
    public String showCreate(Model model) {
        model.addAttribute("person", new Declaration());
        model.addAttribute("genderList", declarationService.gender());
        model.addAttribute("nationalityList", declarationService.nationality());
        model.addAttribute("dayList",declarationService.day());
        model.addAttribute("monthList",declarationService.month());
        model.addAttribute("yearList",declarationService.year());
        return "create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute Declaration declaration, RedirectAttributes redirectAttributes) {
        declarationService.create(declaration);
        redirectAttributes.addFlashAttribute("msg","Update Success!");
        return "redirect:/person/list";
    }

    @GetMapping("showUpdate")
    public String showUpdate(@RequestParam int id, Model model) {
        model.addAttribute("genderList", declarationService.gender());
        model.addAttribute("nationalityList", declarationService.nationality());
        model.addAttribute("dayList",declarationService.day());
        model.addAttribute("monthList",declarationService.month());
        model.addAttribute("yearList",declarationService.year());
        model.addAttribute("person", declarationService.findById(id));
        return "update";
    }

    @PostMapping("update")
    public String update(@ModelAttribute Declaration declaration,
                         @RequestParam int id) {
        declarationService.update(id, declaration);
        return "redirect:/person/list";
    }
}
