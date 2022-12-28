package com.case_study.service;

import com.case_study.model.Facility;
import com.case_study.model.FacilityType;
import com.case_study.model.RentType;
import com.case_study.repository.facility.FacilityRepository;
import com.case_study.repository.facility.FacilityTypeRepository;
import com.case_study.repository.facility.RentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    FacilityRepository facilityRepository;
    @Autowired
    FacilityTypeRepository facilityTypeRepository;
    @Autowired
    RentTypeRepository rentTypeRepository;


    @Override
    public Page<Facility> search(String nameSearch, String facilityType, Pageable pageable) {
        return facilityRepository.search(nameSearch, facilityType, pageable);
    }

    @Override
    public List<FacilityType> findAllFacilityType() {
        return facilityTypeRepository.findAll();
    }

    @Override
    public List<RentType> findAllRentType() {
        return rentTypeRepository.findAll();
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public FacilityType findByIdFacilityType(int facilityType) {
        return facilityTypeRepository.findById(facilityType).orElse(null);
    }

    @Override
    public Facility findFacilityByID(int id) {
        return facilityRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        facilityRepository.delete(id);

    }

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }
}
