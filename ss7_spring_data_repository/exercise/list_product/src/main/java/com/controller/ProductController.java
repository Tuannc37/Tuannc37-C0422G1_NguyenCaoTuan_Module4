package com.controller;

import com.model.Product;
import com.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping(value = {"/",})
    public String showList( Model model,@PageableDefault(page = 0, size = 2) Pageable pageable,
                            @RequestParam Optional<String> name) {
        String nameVal = name.orElse("");
        model.addAttribute("products", iProductService.findAllProduct(nameVal,pageable));
        model.addAttribute("nameVal", nameVal);
        return "list";
    }

    @GetMapping("/showCreate")
    public String showAdd(Model model) {
        model.addAttribute("products", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        iProductService.create(product);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/";
    }

    @GetMapping("/showEdit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("products", iProductService.findById(id));
        return "update";
    }

    @PostMapping("/edit/{id}")
    public String edit(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        iProductService.update(product);
        redirectAttributes.addFlashAttribute("mess", "Cập nhật thành công");
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id,RedirectAttributes redirectAttributes) {
        iProductService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công");
        return "redirect:/";
    }

    @GetMapping("/view")
    public String showDetails(@RequestParam int id, Model model) {
        Optional<Product> product = iProductService.findById(id);
        model.addAttribute("products", product);
        return "list";
    }
}
