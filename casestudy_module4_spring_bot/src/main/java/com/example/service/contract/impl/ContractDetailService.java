package com.example.service.contract.impl;

import com.example.model.contract.ContractDetail;
import com.example.repository.contract.IContractDetailRepository;
import com.example.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository iContractDetailRepository;

    @Override
    public void create(ContractDetail contractDetail) {
        iContractDetailRepository.save(contractDetail);
    }

    @Override
    public List<ContractDetail> findAllByContract_IdContract(Integer id) {
        return iContractDetailRepository.findAllByContract_Id(id);
    }
}
