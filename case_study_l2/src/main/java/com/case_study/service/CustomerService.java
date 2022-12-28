package com.case_study.service;

import com.case_study.model.Customer;
import com.case_study.repository.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> search(String nameSearch, String email, String customerType, Pageable pageable) {
        return customerRepository.search(nameSearch, email, customerType, pageable);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);

    }

    @Override
    public Optional<Customer> findCustomerById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        customerRepository.delete(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
