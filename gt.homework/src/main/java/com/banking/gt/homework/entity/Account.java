package com.banking.gt.homework.entity;

import com.banking.gt.homework.enums.AccountType;
import com.banking.gt.homework.enums.CurrencyType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customerId" , nullable = false)
    private Long customerId;

    @Column(name = "ibanNo" , length = 13, nullable = false)
    private String ibanNo;

    @Column(name = "currentBalance" , nullable = false)
    private Double currentBalance;

    @Column(name = "currencyType" , length = 50, nullable = false)
    @Enumerated(value = EnumType.STRING)
    private CurrencyType currencyType;

    @Column(name = "accountType" , length = 50, nullable = false)
    @Enumerated(value = EnumType.STRING)
    private AccountType accountType;

}
