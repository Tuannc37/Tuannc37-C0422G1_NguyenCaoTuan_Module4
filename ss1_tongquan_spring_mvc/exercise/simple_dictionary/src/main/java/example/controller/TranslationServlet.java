package example.controller;

import example.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TranslationServlet {

    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping("/")
    public String search() {
        return "/dictionary";
    }

    @PostMapping("/result")
    public String meaning(@RequestParam String keyword, Model model) {
       String result = this.dictionaryService.findAll(keyword);
       model.addAttribute("result",result);
       return "/translation";
    }
}
