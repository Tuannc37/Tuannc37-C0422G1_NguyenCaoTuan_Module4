package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.dto.FacilityDto;
import com.example.model.customer.Customer;
import com.example.model.facility.Facility;
import com.example.service.facility.IFacilityTypeService;
import com.example.service.facility.IFacilityService;
import com.example.service.facility.IRenTypeService;

import com.sun.javafx.binding.BidirectionalBinding;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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
        model.addAttribute("facilityDto",new FacilityDto());
        model.addAttribute("facilityTypeList",iFacilityTypeService.findAll());
        model.addAttribute("rentTypeList",iRenTypeService.findAll());
        return "facility/facility_create";
    }

    @PostMapping("createFacility")
    public String create(@ModelAttribute @Valid FacilityDto facilityDto, BindingResult
            bindingResult, RedirectAttributes redirectAttributes,Model model) {
        new FacilityDto().validate(facilityDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("facilityTypeList",iFacilityTypeService.findAll());
            model.addAttribute("rentTypeList",iRenTypeService.findAll());
            return "facility/facility_create";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto,facility);
        iFacilytiService.create(facility);
        redirectAttributes.addFlashAttribute("mess","Thêm mơi thành công!");
        return "redirect:/facility";
    }

    @GetMapping("/showEditFacility/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("facilityDto", iFacilytiService.findByFacilityId(id));
        model.addAttribute("facilityTypeList",iFacilityTypeService.findAll());
        model.addAttribute("rentTypeList",iRenTypeService.findAll());
        return "facility/facility_edit";
    }

    @PostMapping("/editFacility")
    public String edit(@ModelAttribute @Valid FacilityDto facilityDto, BindingResult
            bindingResult, RedirectAttributes redirectAttributes,Model model) {
        new FacilityDto().validate(facilityDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("facilityTypeList",iFacilityTypeService.findAll());
            model.addAttribute("rentTypeList",iRenTypeService.findAll());
            return "facility/facility_edit";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto,facility);
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
