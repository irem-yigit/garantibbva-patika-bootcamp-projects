package com.banking.gt.homework.repository;

import com.banking.gt.homework.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
    Customer findByIdentityNo(Integer identityNo);

    @Query(value = "select c from Customer c where c.email = :email")
    Customer findByEmail(String email);

    Customer findCustomerById(Long id);

    Customer findCustomerByName(String name);

    Customer findCustomerByIdentityNo(Integer identityNo);
}
