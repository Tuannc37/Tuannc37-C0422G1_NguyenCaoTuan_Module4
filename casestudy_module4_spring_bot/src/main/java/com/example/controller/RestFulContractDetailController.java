package com.example.controller;

import com.example.model.contract.ContractDetail;
import com.example.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("restContractDetail")
public class RestFulContractDetailController {
    @Autowired
    private IContractDetailService contractDetailService ;

    @GetMapping("/list/{id}")
    public ResponseEntity<List<ContractDetail>> getAllContractDetail(@PathVariable Integer id ){
        List<ContractDetail> contractDetails = this.contractDetailService.findAllByContract_IdContract(id);
        if (contractDetails.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractDetails , HttpStatus.OK);
    }
}
