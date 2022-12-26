package com.case_study.repository;

import com.case_study.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "select c.* from `customer` c where c.delete_status = 1 and c.name like %:name% and c.email like %:email% " +
            "and customer_type_id like %:type%", nativeQuery = true)
    Page<Customer> search(@Param("name") String nameSearch,
                          @Param("email") String email,
                          @Param("type") String customerType,
                          Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "update customer set delete_status = 0 where id = :id", nativeQuery = true)
    void delete(@Param("id") int id);

}
