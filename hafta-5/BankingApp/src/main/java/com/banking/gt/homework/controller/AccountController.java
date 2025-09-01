package com.banking.gt.homework.controller;

import com.banking.gt.homework.dto.AccountProcessDTO;
import com.banking.gt.homework.entity.Account;
import com.banking.gt.homework.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> saveAccount(@RequestBody Account account){
        Account savedAccount = accountService.saveAccount(account);
        return ResponseEntity.ok(savedAccount);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteAccount(@PathVariable Long id){
        accountService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/customer/{customerId}")
    public ResponseEntity<List<Account>> getAllByCustomerId(@PathVariable Long customerId){
        List<Account> accounts = accountService.getAllByCustomerId(customerId);
        return ResponseEntity.ok(accounts);
    }

    @PostMapping("/drawing")
    public ResponseEntity<Account> withDrawMoney(@RequestBody AccountProcessDTO dto){
        Account savedAccount = accountService.withDrawMoney(dto);
        if(savedAccount != null)
            return ResponseEntity.ok(savedAccount);
        else
            return ResponseEntity.badRequest().build();
    }

    @PostMapping("/deposit")
    public ResponseEntity<Account> depositMoney(@RequestBody AccountProcessDTO dto){
        Account savedAccount = accountService.depositMoney(dto);
        if(savedAccount != null)
            return ResponseEntity.ok(savedAccount);
        else
            return ResponseEntity.badRequest().build();
    }
}
