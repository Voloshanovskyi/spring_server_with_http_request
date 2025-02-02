package org.example.service;

import org.example.entity.Account;
import org.example.entity.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static org.example.utils.AccountUtils.findDefaultBill;

@Service
public class PaymentService {
    private final AccountService accountService;
@Autowired
    public PaymentService(AccountService accountService) {
        this.accountService = accountService;
    }

    public String pay(Long accountId, BigDecimal paymentAmount){
        Account account = accountService.getById(accountId);
        Bill defaultBill = findDefaultBill(account);
        defaultBill.setAmount(defaultBill.getAmount().subtract(paymentAmount));
        accountService.update(account);
        return "Success";
    }
}
