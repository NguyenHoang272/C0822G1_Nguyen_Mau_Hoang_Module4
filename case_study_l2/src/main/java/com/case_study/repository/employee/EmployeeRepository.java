package com.case_study.repository.employee;

import com.case_study.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "select * from Employee where delete_status = 1", nativeQuery = true)
    Page<Employee> getListEmployee(Pageable pageable);
}
