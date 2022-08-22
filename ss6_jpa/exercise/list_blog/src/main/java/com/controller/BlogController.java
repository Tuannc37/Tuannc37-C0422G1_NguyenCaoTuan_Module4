package com.controller;

import com.model.Blog;
import com.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("showList")
    public String index(@RequestParam(required = false,defaultValue = "") String nameBlog, Model model) {
        List<Blog> blogList = blogService.findAll(nameBlog);
        model.addAttribute("blog", blogList);
        return "/list";
    }

    @GetMapping("showCreate")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute Blog blog,
                         RedirectAttributes redirectAttributes) {
        blogService.create(blog);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công!");
        return "redirect:/blog/showList";
    }

    @GetMapping("showEdit/{id}")
    public String edit(@PathVariable int id, Model model ) {
        model.addAttribute("blog", blogService.findById(id));
        return "/update";
    }

    @PostMapping("update/{id}")
    public String edit(@ModelAttribute Blog blog,
                       @PathVariable int id,
                       RedirectAttributes redirectAttributes) {
        blogService.update(id, blog);
        redirectAttributes.addFlashAttribute("mess", "Cập nhật thành công!");
        return "redirect:/blog/showList";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirect) {
        blogService.delete(id);
        redirect.addFlashAttribute("success", "Xóa thành công!");
        return "redirect:/blog/showList";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/view";
    }
}
