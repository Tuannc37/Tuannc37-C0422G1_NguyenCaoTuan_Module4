package com.example.controller;
import com.example.model.Blog;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("showList")
    public String showList(@PageableDefault(page = 0, size = 5) Pageable pageable, Model model,
                           @RequestParam Optional<String> name) {
        String nameVal = name.orElse("");
        model.addAttribute("blog",blogService.findAllByNameBlog(nameVal,pageable));
        model.addAttribute("nameVal",nameVal);
        return "blog/test";
    }

    @GetMapping("showCreate")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("category", categoryService.findAllCategory());
        return "blog/create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute Blog blog,
                         RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công!");
        return "redirect:/blog/showList";
    }

    @GetMapping("showEdit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        Optional<Blog> blog = blogService.findId(id);
        model.addAttribute("category", categoryService.findAllCategory());
        model.addAttribute("blog", blog);
        return "blog/update";
    }

    @PostMapping("edit/{id}")
    public String edit(@ModelAttribute Blog blog,RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Sửa thành công!");
        return "redirect:/blog/showList";
    }

    @PostMapping("delete")
    public String delete(@RequestParam int id,
                         RedirectAttributes redirectAttributes) {
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công!");
        return "redirect:/blog/showList";
    }

    @GetMapping("view")
    public String view(@RequestParam int id, Model model) {
        Optional<Blog> blog = blogService.findId(id);
        model.addAttribute("blog", blog);
        return "blog/list";
    }
}
