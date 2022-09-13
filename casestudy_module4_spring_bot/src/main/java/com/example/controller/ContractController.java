package com.example.controller;

import com.example.dto.ContractDetailDto;
import com.example.dto.ContractDto;
import com.example.model.contract.AttachFacility;
import com.example.model.contract.Contract;
import com.example.model.contract.ContractDetail;
import com.example.model.customer.Customer;
import com.example.model.employee.Employee;
import com.example.model.facility.Facility;
import com.example.service.contract.IAttachFacilityService;
import com.example.service.contract.IContractDetailService;
import com.example.service.contract.IContractService;
import com.example.service.customer.ICustomerService;
import com.example.service.facility.IFacilityService;
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

@Controller
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

    @GetMapping(value = "contract")
    public String showList(@PageableDefault(page = 0, size = 5) Pageable pageable, Model model) {
        model.addAttribute("contract", contractService.totalMoneyContract(pageable));
        model.addAttribute("contractDetail", new Contract());
        model.addAttribute("attachFacilityList", new AttachFacility());
        model.addAttribute("customerList", customerService.findAllCustomer());
        model.addAttribute("facilityList", facilityService.findAllFacility());
        model.addAttribute("contractDetailList", attachFacilityService.findAllAttachFacility());
        return "contract/test";
    }

    @PostMapping("/createContractDetail")
    public String createContractDetail(@ModelAttribute("contractDto") @Valid ContractDetailDto contractDetailDto,
                                       BindingResult bindingResult,
                                       RedirectAttributes redirectAttributes) {
        new ContractDetailDto().validate(contractDetailDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "redirect:/contract";
        }
        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto, contractDetail);
        contractDetailService.createContractDetail(contractDetail);
        redirectAttributes.addFlashAttribute("mess", "thêm dịch vụ đi kèm thành công");
        return "redirect:/contract";
    }

    @PostMapping("/createContract")
    public String createContract(@ModelAttribute("contractDto") @Valid ContractDto contractDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        new ContractDto().validate(contractDto, bindingResult);
        if (bindingResult.hasErrors()){
            return "redirect:/contract";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);

        Facility facility = new Facility();
        facility.setId(contractDto.getFacility().getId());
        contract.setFacility(facility);

        Customer customer = new Customer();
        customer.setId(contractDto.getCustomer().getId());
        contract.setCustomer(customer);

        Employee employee = new Employee();
        employee.setId(contractDto.getEmployee().getId());
        contract.setEmployee(employee);

        contractService.create(contract);
        redirectAttributes.addFlashAttribute("mess", "thêm hợp đồng thành công");
        return "redirect:/contract";
    }

}
