package com.case_study.service;

import com.case_study.dto.CustomerUsingFacility;
import com.case_study.model.AttachFacility;
import com.case_study.model.Contract;
import com.case_study.model.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);

    List<AttachFacility> getAttachFacilities();

    List<ContractDetail> getListContractDetail();

    List<ContractDetail> getContractDetail(int id);

    Contract findById(int contractId);

    AttachFacility findAttachFacilityId(int attachId);

    void saveContractDetail(ContractDetail contractDetail);

    void save(Contract contract);

    ContractDetail findContractDetailId(int attachId, int contractId);

    Page<CustomerUsingFacility> findCustomerListUsingFacility(Pageable pageable);

    List<ContractDetail> getListContractDetailByCustomerId(int customerId);
}
