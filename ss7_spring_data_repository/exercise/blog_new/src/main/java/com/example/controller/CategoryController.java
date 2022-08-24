package com.example.controller;

import com.example.model.Category;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("showList")
    public String showList(@PageableDefault Pageable pageable, Model model){
        Page<Category> categories = categoryService.findAllCategory(pageable);
        model.addAttribute("category", categories);
        return "/category/list";
    }

    @GetMapping("showCreate")
    public String showCreate(Model model) {
        model.addAttribute("category", new Category());
        return "/category/create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute Category category,
                         RedirectAttributes redirectAttributes) {
        categoryService.create(category);
        redirectAttributes.addFlashAttribute("mess", "Create OK!");
        return "redirect:/category/showList";
    }

    @GetMapping("showViewBlog/{id}")
    public String viewBlog(@PathVariable int id){
        return "redirect:/blog/showList/" + id + "/" + 0;
    }

    @GetMapping("showEdit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        Optional<Category> category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "/category/update";
    }

    @PostMapping("edit")
    public String edit(@ModelAttribute Category category,
                       RedirectAttributes redirectAttributes) {
        categoryService.update(category);
        redirectAttributes.addFlashAttribute("mess", "Edit OK!");
        return "redirect:/category/showList";
    }

    @PostMapping("delete")
    public String delete(@RequestParam int id,
                         RedirectAttributes redirectAttributes) {
        categoryService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Delete OK!");
        return "redirect:/category/showList";
    }
}
