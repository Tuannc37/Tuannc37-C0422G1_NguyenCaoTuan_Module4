package com.controller;

import com.dto.ListenDto;
import com.model.Listen;
import com.service.IListenService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ListenController {
    @Autowired
    private IListenService listenService;

    @GetMapping("showList")
    public String index(Model model) {
        List<Listen> listenList = listenService.findAll();
        model.addAttribute("listenForm", listenList);
        return "/list";
    }

    @GetMapping("showCreate")
    public String showCreate(Model model) {
        model.addAttribute("listenDto", new ListenDto());
        return "/create";
    }

    @PostMapping(value = "/create")
    public String createStudent(@ModelAttribute("listenDto") @Valid ListenDto listenDto,
                                BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        new ListenDto().validate(listenDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        Listen listen = new Listen();
        BeanUtils.copyProperties(listenDto, listen);
        this.listenService.create(listen);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công!");
        return "redirect:/showList";
    }

    @GetMapping("showEdit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("listenDto", listenService.findId(id));
        return "/update";
    }

    @PostMapping(value = "edit/{id}")
    public String edit(@ModelAttribute("listenDto") @Valid ListenDto listenDto,
                       BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new ListenDto().validate(listenDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/update";
        }
        Listen listen = new Listen();
        BeanUtils.copyProperties(listenDto, listen);
        listenService.update(listen);
        redirectAttributes.addFlashAttribute("msg", "Sửa đổi thành công!");
        return "redirect:/showList";
    }

}
