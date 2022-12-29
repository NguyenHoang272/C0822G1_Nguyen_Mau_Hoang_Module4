package com.case_study.repository.contract;

import com.case_study.model.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContractDetailRepository extends JpaRepository<ContractDetail,Integer> {

    @Query(value = "select * from contract_detail where contract_id = :id", nativeQuery = true)
    List<ContractDetail> findList(@Param("id") int id);

    @Query(value = "select * from contract_detail where attach_facility_id = :attachId and contract_id = :contractId", nativeQuery = true)
    ContractDetail findContractDetailId(@Param("attachId") int attachId,
                                        @Param("contractId") int contractId);

    @Query(value = "select * from `contract_detail` join `contract` on contract.id = contract_detail.contract_id join `customer` on contract.customer_id = customer.id where customer.id = :customerId", nativeQuery = true)
    List<ContractDetail> getListContractDetailByCustomerId(@Param("customerId") int customerId);
}
