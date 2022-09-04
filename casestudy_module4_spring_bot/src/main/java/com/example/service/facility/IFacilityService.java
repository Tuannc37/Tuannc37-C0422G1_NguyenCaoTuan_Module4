package com.example.service.facility;
import com.example.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Optional;

public interface IFacilityService {

    Page<Facility> findFacilityAll(String name, Pageable pageable);

    Optional<Facility> findByFacilityId(int id);

    void create(Facility facility);

    void delete(int id);

    void update(Facility facility);
}
