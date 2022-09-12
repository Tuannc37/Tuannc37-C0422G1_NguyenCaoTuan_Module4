package com.example.repository.contract;

import com.example.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Repository
@Transactional
public interface IContractRepository extends JpaRepository<Contract,Integer> {
    Page<Contract> findAllByEndDateGreaterThanAndCustomer_NameContaining(LocalDate now, String name, Pageable pageable);
}
