package com.case_study.service;

import com.case_study.model.Employee;
import com.case_study.repository.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.getListEmployee(pageable);
    }

    @Override
    public List<Employee> getListEmployee() {
        return employeeRepository.findAll();
    }
}
