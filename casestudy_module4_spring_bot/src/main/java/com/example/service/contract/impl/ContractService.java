package com.example.service.contract.impl;

import com.example.model.contract.AttachFacility;
import com.example.model.contract.Contract;
import com.example.model.contract.ContractDetail;
import com.example.repository.contract.IAttachFacilityRepository;
import com.example.repository.contract.IContractDetailRepository;
import com.example.repository.contract.IContractRepository;
import com.example.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository contractRepository;

    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;

    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Override
    public Page<Contract> findAllContractPage(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Page<Contract> totalMoneyContract(Pageable pageable) {
        Page<Contract> contractList = this.findAllContractPage(pageable);
        List<AttachFacility> attachFacilityList = attachFacilityRepository.findAll();
        List<ContractDetail> contractDetailList = contractDetailRepository.findAll();
        for (Contract c: contractList) {
            double totalDetail = 0;
            double costFacility = 0;

            for (ContractDetail item : contractDetailList) {
                if (item.getContract().getId() == c.getId()) {
                    for (AttachFacility attach : attachFacilityList) {
                        if (attach.getId() == item.getAttachFacility().getId()) {
                           costFacility += item.getQuantity() * attach.getCost();
                        }
                    }
                }
            }
            totalDetail = costFacility + c.getFacility().getCost();
            c.setTotalMoney(totalDetail);
        }
        return contractList;
    }


    @Override
    public List<Contract> findAllContract() {
        return contractRepository.findAll();
    }

    @Override
    public void create(Contract contract) {
        contractRepository.save(contract);
    }
}
