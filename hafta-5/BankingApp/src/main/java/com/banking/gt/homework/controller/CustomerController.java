package com.banking.gt.homework.controller;

import com.banking.gt.homework.entity.Customer;
import com.banking.gt.homework.service.CustomerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.saveCustomer(customer);
        return ResponseEntity.ok(savedCustomer);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Long id){
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
        Customer customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    @GetMapping(value = "/identity/{identityNo}")
    public ResponseEntity<Customer> getCustomerByIdentityNo(@PathVariable Integer identityNo){
        Customer customer = customerService.getCustomerByIdentityNo(identityNo);
        return ResponseEntity.ok(customer);
    }
}
