package com.case_study.service;

import com.case_study.model.Facility;
import com.case_study.model.FacilityType;
import com.case_study.model.RentType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    Page<Facility> search(String nameSearch, String facilityType, Pageable pageable);
    List<FacilityType> findAllFacilityType();
    List<RentType> findAllRentType();
    void save(Facility facility);
    FacilityType findByIdFacilityType(int facilityType);
    Facility findFacilityByID(int id);
    void delete(int id);
    List<Facility> findAll();
}
