package com.example.controller;

import com.example.model.AppBook;
import com.example.service.IAppBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class AppBookController {
    @Autowired
    private IAppBookService iAppBookService;

    @GetMapping(value = {"/",})
    public String showList(Model model, @PageableDefault(page = 0, size = 2) Pageable pageable,
                           @RequestParam Optional<String> name) {
        String nameVal = name.orElse("");
        model.addAttribute("app", iAppBookService.findAllAppBook(nameVal,pageable));
        model.addAttribute("nameVal", nameVal);
        return "list";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam Integer id, Model model) {
        model.addAttribute("book", iAppBookService.findById(id));
        return "view";
    }

    @PostMapping("/rent")
    public String update(@RequestParam Integer id, Model model) throws Exception {
        AppBook appBook = iAppBookService.findById(id);
        if (appBook == null) {
            throw new Exception();
        }
        if (appBook.getAmountRemaining() == 0) {
            model.addAttribute("msg", "Sách bạn chọn đã hết!!");
            model.addAttribute("app", appBook);
            return "view";
        }
        appBook.setAmountRemaining(appBook.getAmountRemaining() - 1);
        iAppBookService.update(appBook);
        model.addAttribute("app", appBook);
        model.addAttribute("msg", "Thuê thành công!!");
        return "list";
    }

    @PostMapping("/pay")
    public String pay(@RequestParam Integer id, Model model) throws Exception {
        AppBook appBook = iAppBookService.findById(id);
        if (appBook == null) {
            throw new Exception();
        }
        if (appBook.getOriginalQuantity() == appBook.getAmountRemaining()) {
            model.addAttribute("msg", "Số lượng sách đã đủ!!");
            return "list";
        }
        appBook.setAmountRemaining(appBook.getAmountRemaining() + 1);
        iAppBookService.update(appBook);
        model.addAttribute("msg", "Bạn đã trả sách thành công!!");
        return "list";
    }

    @ExceptionHandler(value = Exception.class)
    public String error() {
        return "error";
    }
}
