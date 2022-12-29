package com.case_study.controller;

import com.case_study.model.ContractDetail;
import com.case_study.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/contract-detail/v1")
public class ContractDetailRestController {
    @Autowired
    IContractService contractService;

    @GetMapping("contract-detail/{contractId}")
    public ResponseEntity<List<ContractDetail>> getListContractDetail(@PathVariable int contractId) {
        List<ContractDetail> contractDetailList = contractService.getContractDetail(contractId);
        if (contractDetailList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractDetailList, HttpStatus.OK);
    }

    @GetMapping("customer-using-facility/{customerId}")
    public ResponseEntity<List<ContractDetail>> getListContractDetailByCustomerId(@PathVariable int customerId) {
        List<ContractDetail> contractDetailList = contractService.getListContractDetailByCustomerId(customerId);
        if (contractDetailList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractDetailList, HttpStatus.OK);
    }
}
