package com.example.repository.contract;

import com.example.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
    List<ContractDetail> findAllByContract_Id(Integer id);
}
