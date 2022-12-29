package com.case_study.controller;

import com.case_study.model.Facility;
import com.case_study.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contract/v1")
public class ContractRestController {
    @Autowired
    IFacilityService facilityService;
    @GetMapping("/{id}")
    public ResponseEntity<Facility> getFacilityById(@PathVariable int id) {
        Facility facility = facilityService.findFacilityByID(id);
        if (facility == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(facility, HttpStatus.OK);
    }
}
