package com.controller;
import com.model.MailBox;
import com.service.IMailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {

    @Autowired
    private IMailBoxService iMailBoxService;

    @GetMapping(value = "/")
    public String goCreateMailBox(Model model){
        model.addAttribute("email", new MailBox());
        model.addAttribute("languages",iMailBoxService.findLanguage());
        model.addAttribute("pageSize",iMailBoxService.findPageSize());
        return "index";
    }

    @PostMapping(value = "/result")
    public String loadResult (@ModelAttribute("email") MailBox mailBox,
                              ModelMap modelMap) {
        modelMap.addAttribute("languages", mailBox.getLanguages());
        modelMap.addAttribute("pageSize", mailBox.getPageSize());
        modelMap.addAttribute("filter", mailBox.isFilter());
        modelMap.addAttribute("signature", mailBox.getSignature());
        return "result";
    }


}
