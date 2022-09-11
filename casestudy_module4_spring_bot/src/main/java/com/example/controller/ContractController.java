package com.example.controller;

import com.example.model.contract.AttachFacility;
import com.example.model.contract.Contract;
import com.example.model.customer.Customer;
import com.example.service.contract.IAttachFacilityService;
import com.example.service.contract.IContractDetailService;
import com.example.service.contract.IContractService;
import com.example.service.customer.ICustomerService;
import com.example.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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
        model.addAttribute("contractDetail", new Contract());
        model.addAttribute("attachFacilityList", new AttachFacility());
        model.addAttribute("customerList", customerService.findAllCustomer());
        model.addAttribute("facilityList", facilityService.findAllFacility());
        model.addAttribute("contractDetailList", attachFacilityService.findAllAttachFacility());
        return "contract/contract_list";
    }

    @GetMapping("showListAttach/{id}")
    public String showListAttach(@PageableDefault(value = 5) Pageable pageable,
                                 @PathVariable int id, Model model) {
        model.addAttribute("contract", contractService.totalMoneyContract(pageable));
        model.addAttribute("contractDetail", new Contract());
        model.addAttribute("attachFacilityList", attachFacilityService.findAllById(id));
        model.addAttribute("customerList", customerService.findAllCustomer());
        model.addAttribute("facilityList", facilityService.findAllFacility());
        model.addAttribute("contractDetailList", attachFacilityService.findAllAttachFacility());
        model.addAttribute("flag", 1);
        return "contract/contract_list";
    }

    @GetMapping("showCreate")
    public String showCreate(Model model) {
        model.addAttribute("contractDetail", new Contract());
        model.addAttribute("customerList", customerService.findAllCustomer());
        model.addAttribute("facilityList", facilityService.findAllFacility());
        return "contract/contract_list";
    }

    @PostMapping("createContract")
    public ResponseEntity<?> create(@RequestBody Contract contract) {
        contractService.create(contract);
        List<Contract> contracts = contractService.findAllContract();
        int idContract = 0;
        for (Contract item : contracts) {
            idContract = item.getId();
        }
        return new ResponseEntity(idContract, HttpStatus.OK);
    }

}
