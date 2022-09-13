package com.example.service.contract;

import com.example.model.contract.Contract;
import com.example.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    void create(ContractDetail contractDetail);
    List<ContractDetail> findAllByContract_IdContract(Integer id);
    void createContractDetail(ContractDetail contractDetail);
}
