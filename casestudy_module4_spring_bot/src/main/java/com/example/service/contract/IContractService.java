package com.example.service.contract;

import com.example.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface IContractService {
    Page<Contract> findAllContractPage(Pageable pageable);

    Page<Contract> totalMoneyContract(Pageable pageable);

    List<Contract> findAllContract();

    void create(Contract contract);
}
