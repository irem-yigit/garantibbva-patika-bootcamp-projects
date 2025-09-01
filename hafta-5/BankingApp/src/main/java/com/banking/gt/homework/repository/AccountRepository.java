package com.banking.gt.homework.repository;

import com.banking.gt.homework.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findAllByCustomerId(Long customerId);

    @Query(value = "select a from Account a where a.ibanNo = :ibanNo")
    Account findByIbanNo(String ibanNo);

    Account findAccountById(Long id);
}
