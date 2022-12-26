package com.case_study.service;

import com.case_study.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Page<Customer> search(String nameSearch, String email, String customerType, Pageable pageable);

    void save(Customer customer);

    Optional<Customer> findCustomerById(int id);

    void delete(int id);

    List<Customer> findAll();
}
