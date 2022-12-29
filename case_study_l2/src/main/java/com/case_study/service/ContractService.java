package com.case_study.service;


import com.case_study.dto.CustomerUsingFacility;
import com.case_study.model.AttachFacility;
import com.case_study.model.Contract;
import com.case_study.model.ContractDetail;
import com.case_study.repository.contract.AttachRepository;
import com.case_study.repository.contract.ContractDetailRepository;
import com.case_study.repository.contract.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService{
    @Autowired
    ContractRepository contractRepository;

    @Autowired
    AttachRepository attachRepository;

    @Autowired
    ContractDetailRepository contractDetailRepository;
    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.getList(pageable);
    }

    @Override
    public List<AttachFacility> getAttachFacilities() {
        return attachRepository.findAll();
    }

    @Override
    public List<ContractDetail> getListContractDetail() {
        return contractDetailRepository.findAll();
    }

    @Override
    public List<ContractDetail> getContractDetail(int id) {
        return contractDetailRepository.findList(id);
    }

    @Override
    public Contract findById(int contractId) {
        return contractRepository.findById(contractId).orElse(null);
    }

    @Override
    public AttachFacility findAttachFacilityId(int attachId) {
        return attachRepository.findById(attachId).orElse(null);
    }

    @Override
    public void saveContractDetail(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public ContractDetail findContractDetailId(int attachId, int contractId) {
        return contractDetailRepository.findContractDetailId(attachId,contractId);
    }

    @Override
    public Page<CustomerUsingFacility> findCustomerListUsingFacility(Pageable pageable) {
        return contractRepository.findCustomerListUsingFacility(pageable);
    }

    @Override
    public List<ContractDetail> getListContractDetailByCustomerId(int customerId) {
        return contractDetailRepository.getListContractDetailByCustomerId(customerId);
    }
}
