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

    @PostMapping("/borrow")
    public String borrowBook(@RequestParam Integer id, Model model) throws Exception {
        AppBook appBook = iAppBookService.findById(id);

        if (appBook == null) {
            throw new Exception();
        }

        if (appBook.getAmountRemaining() == 0){
            model.addAttribute("msg","Sách bạn mượn đã hết");
            return "redirect:/";
        }

        appBook.setAmountRemaining(appBook.getAmountRemaining() - 1 );
        iAppBookService.update(appBook);
        model.addAttribute("msg","Mượn sách thành công");
        model.addAttribute("app", appBook);
        return "redirect:/";
    }

    @PostMapping("/pay")
    public String giveBack(@RequestParam Integer id, Model model) throws Exception {
        AppBook appBook = iAppBookService.findById(id);

        if (appBook == null) {
            throw new Exception();
        }

        if (appBook.getAmountRemaining() == appBook.getOriginalQuantity()){
            model.addAttribute("msg","Sách đã đủ");
            return "redirect:/";
        }
        appBook.setAmountRemaining(appBook.getAmountRemaining() + 1 );
        iAppBookService.update(appBook);
        model.addAttribute("msg","Trả sách thành công");
        model.addAttribute("detail", appBook);
        return "redirect:/";
    }

    @ExceptionHandler(value = Exception.class)
    public String error() {
        return "/error";
    }
}
