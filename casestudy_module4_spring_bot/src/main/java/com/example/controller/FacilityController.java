package com.example.controller;

import com.example.model.facility.Facility;
import com.example.service.facility.IFacilityTypeService;
import com.example.service.facility.IFacilityService;
import com.example.service.facility.IRenTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class FacilityController {

    @Autowired
    private IFacilityService iFacilytiService;

    @Autowired
    private IFacilityTypeService iFacilityTypeService;

    @Autowired
    private IRenTypeService iRenTypeService;

    @GetMapping(value = {"facility",})
    public String showListFacility(Model model, @PageableDefault(page = 0, size = 5) Pageable pageable,
                           @RequestParam Optional<String> name) {
        String nameVal = name.orElse("");
        model.addAttribute("facility", iFacilytiService.findFacilityAll(nameVal,pageable));
        model.addAttribute("nameVal", nameVal);
        return "facility/facility_list";
    }

    @GetMapping("showCreateFacility")
    public String showCreate(Model model) {
        model.addAttribute("facility",new Facility());
        model.addAttribute("facilityTypeList",iFacilityTypeService.findAll());
        model.addAttribute("rentTypeList",iRenTypeService.findAll());
        return "facility/facility_create";
    }

    @PostMapping("createFacility")
    public String create(@ModelAttribute Facility facility, RedirectAttributes redirectAttributes) {
        iFacilytiService.create(facility);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công!!");
        return "redirect:/facility";
    }

    @GetMapping("/showEditFacility/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("facility", iFacilytiService.findByFacilityId(id));
        model.addAttribute("facilityTypeList",iFacilityTypeService.findAll());
        model.addAttribute("rentTypeList",iRenTypeService.findAll());
        return "facility/facility_edit";
    }

    @PostMapping("/editFacility")
    public String edit(@ModelAttribute Facility facility, RedirectAttributes redirectAttributes) {
        iFacilytiService.update(facility);
        redirectAttributes.addFlashAttribute("mess", "Cập nhật thành công");
        return "redirect:/facility";
    }

    @PostMapping("/deleteFacility")
    public String delete(@RequestParam int id,RedirectAttributes redirectAttributes) {
        iFacilytiService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công");
        return "redirect:/facility";
    }
}
