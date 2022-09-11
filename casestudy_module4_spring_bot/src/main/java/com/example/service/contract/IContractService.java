package com.example.service.contract;

import com.example.dto.TotalDto;
import com.example.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<Contract> findAllContractPage(Pageable pageable);

    Page<Contract> totalMoneyContract(Pageable pageable);

    List<Contract> findAllContract();

    void create(Contract contract);
}
