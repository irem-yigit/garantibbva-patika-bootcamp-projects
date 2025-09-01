package com.banking.gt.homework.service;

import com.banking.gt.homework.entity.Customer;
import com.banking.gt.homework.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public void delete(Long id) {
        Customer customer = customerRepository.findCustomerById(id);
        customerRepository.delete(customer);
    }

    public Customer getCustomerById(Long id) {
        Customer customer = customerRepository.findCustomerById(id);
        return customer;
    }

    public Customer getCustomerByIdentityNo(Integer identityNo) {
        Customer customer = customerRepository.findCustomerByIdentityNo(identityNo);
        return customer;
    }
}
