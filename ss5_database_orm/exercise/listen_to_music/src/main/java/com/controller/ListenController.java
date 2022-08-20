package com.controller;

import com.model.Listen;
import com.model.ListenForm;
import com.service.IListenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("listen")
@PropertySource("classpath:upload_file.properties")
public class ListenController {
    @Autowired
    private IListenService listenService;

    @GetMapping("showList")
    public String index(@RequestParam(required = false,defaultValue = "") String listenName, Model model) {
        List<Listen> listenList = listenService.findAll(listenName);
        model.addAttribute("listen", listenList);
        return "/list";
    }

    @GetMapping("showCreate")
    public String showCreate(Model model) {
        model.addAttribute("listen", new Listen());
        return "/create";
    }

    @Value("${file-upload}")
    private String fileUpload;

    @PostMapping("/create")
    public ModelAndView saveProduct(@ModelAttribute ListenForm listenForm) {
        MultipartFile multipartFile = listenForm.getPathFile();

        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(listenForm.getPathFile().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Listen listen = new Listen(listenForm.getId(), listenForm.getListenName(), listenForm.getArtist(),
                listenForm.getCategory(), fileName);
        listenService.create(listen);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("listen", listenForm);
        modelAndView.addObject("mess", "Thêm mới thành công!");
        return modelAndView;
    }

    @GetMapping("showEdit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        Listen listen = listenService.findById(id);
        model.addAttribute("listen", listen);
        return "/update";
    }

    @PostMapping("edit/{id}")
    public String edit(@ModelAttribute Listen listen,
                       @PathVariable int id,
                       RedirectAttributes redirectAttributes) {
        listenService.update(id, listen);
        redirectAttributes.addFlashAttribute("mess", "Update OK!");
        return "redirect:/listen/showList";
    }

    @PostMapping("delete")
    public String delete(@RequestParam int id,
                         RedirectAttributes redirectAttributes) {
        listenService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Delete OK!");
        return "redirect:/listen/showList";
    }
}
