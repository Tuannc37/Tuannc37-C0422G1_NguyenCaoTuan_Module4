package com.example.controller;

import com.example.service.contract.IAttachFacilityService;
import com.example.service.contract.IContractDetailService;
import com.example.service.contract.IContractService;
import com.example.service.customer.ICustomerService;
import com.example.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
public class ContractController {

    @Autowired
    private IContractService contractService;

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IContractDetailService contractDetailService;

    @GetMapping("contract")
    public String showList(@PageableDefault(page = 0, size = 5) Pageable pageable, Model model) {
        model.addAttribute("contract", contractService.totalMoneyContract(pageable));
        model.addAttribute("customerList", customerService.findAllCustomer());
        model.addAttribute("facilityList", facilityService.findAllFacility());
        model.addAttribute("attachFacilityList", attachFacilityService.findAllAttachFacility());
        return "contract/contract_list";
    }
}
