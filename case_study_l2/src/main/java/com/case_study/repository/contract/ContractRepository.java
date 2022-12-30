package com.case_study.repository.contract;

import com.case_study.dto.CustomerUsingFacility;
import com.case_study.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface    ContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "select * from contract where delete_status = 1", nativeQuery = true)
    Page<Contract> getList(Pageable pageable);

    @Query(value = "select customer.id customerId,customer.name customerName,contract.date_start startDay,contract.date_end endDay,GROUP_CONCAT(facility.name) as facilityList from `contract` join `customer` on contract.customer_id=customer.id join `facility` on contract.facility_id=facility.id  group by customer.name", nativeQuery = true)
    Page<CustomerUsingFacility> findCustomerListUsingFacility(Pageable pageable);
}
