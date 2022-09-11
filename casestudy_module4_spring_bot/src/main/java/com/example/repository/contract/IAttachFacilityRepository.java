package com.example.repository.contract;

import com.example.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility,Integer> {
    @Query(value = "select * from dich_vu_di_kem a " +
            " join hop_dong_chi_tiet cd on a.ma_dich_vu_di_kem = cd.ma_dich_vu_di_kem " +
            " join hop_dong c on cd.ma_hop_dong = c.ma_hop_dong " +
            " where c.ma_hop_dong = :id ",
            countQuery = "select count(*) from dich_vu_di_kem a " +
                    " join hop_dong_chi_tiet cd on a.ma_dich_vu_di_kem = cd.ma_dich_vu_di_kem " +
                    " join hop_dong c on cd.ma_hop_dong = c.ma_hop_dong " +
                    " where c.ma_hop_dong = :id ",nativeQuery = true)
    List<AttachFacility> findAllAttachFacility(@Param("id") int id);
}
