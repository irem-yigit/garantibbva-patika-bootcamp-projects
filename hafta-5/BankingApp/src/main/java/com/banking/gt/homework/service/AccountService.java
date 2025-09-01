package com.banking.gt.homework.service;

import com.banking.gt.homework.dto.AccountProcessDTO;
import com.banking.gt.homework.entity.Account;
import com.banking.gt.homework.enums.AccountType;
import com.banking.gt.homework.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account saveAccount(Account account) {
        Account savedAccount = accountRepository.save(account);
        return savedAccount;
    }

    public void delete(Long id) {
        Account account = accountRepository.findAccountById(id);
        accountRepository.delete(account);
    }

    public List<Account> getAllByCustomerId(Long customerId) {
        List<Account> accounts = accountRepository.findAllByCustomerId(customerId);
        return accounts;
    }

    public Account withDrawMoney(AccountProcessDTO dto) {
        Account account = accountRepository.findAccountById(dto.getAccountId());
        if(account.getAccountType() == AccountType.DRAWING) {
            Double currentMoney = account.getCurrentBalance() - dto.getMoney();
            account.setCurrentBalance(currentMoney);
            accountRepository.save(account);
            return account;
        }
        return null;
    }

    public Account depositMoney(AccountProcessDTO dto) {
        Account account = accountRepository.findAccountById(dto.getAccountId());
        if (account.getAccountType() == AccountType.DEPOSIT){
            Double currentMoney = account.getCurrentBalance() + dto.getMoney();
            account.setCurrentBalance(currentMoney);
            accountRepository.save(account);
            return account;
        }
        return null;
    }
}
