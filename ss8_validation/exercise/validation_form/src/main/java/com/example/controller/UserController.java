package com.example.controller;

import com.example.dto.UserDto;
import com.example.model.User;
import com.example.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("/")
    public String showListUser(Model model){
        List<User> userList = iUserService.findAll();
        model.addAttribute("listUser",userList);
        return "index";
    }

    @GetMapping(value = "/showCreate")
    public String goCreateStudent(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "create";
    }

    @PostMapping(value = "/create")
    public String createStudent(@ModelAttribute("userDto") @Valid UserDto userDto, BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {

        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        this.iUserService.save(user);
        redirectAttributes.addFlashAttribute("msg", "Register successfully!");
        return "redirect:/";
    }
}
