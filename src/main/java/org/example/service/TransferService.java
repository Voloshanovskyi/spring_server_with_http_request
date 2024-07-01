package org.example.service;

import org.example.entity.Account;
import org.example.entity.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferService {
    private final AccountService accountService;

    @Autowired
    public TransferService(AccountService accountService) {
        this.accountService = accountService;
    }

    public void transfer(Long accountIdFrom, Long accountIdTo, BigDecimal amount) {
        if (accountIdFrom == null || accountIdTo == null || amount == null) {
            throw new IllegalArgumentException("Account IDs and amount must not be null");
        }

        Account accountFrom = accountService.getById(accountIdFrom);
        Account accountTo = accountService.getById(accountIdTo);

        Bill billFrom = findDefaultBill(accountFrom);
        Bill billTo = findDefaultBill(accountTo);

        if (billFrom == null || billTo == null) {
            throw new IllegalStateException("Bills must not be null");
        }

        if (billFrom.getAmount().compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        billFrom.setAmount(billFrom.getAmount().subtract(amount));
        billTo.setAmount(billTo.getAmount().add(amount));

        accountService.update(accountFrom);
        System.out.println("BillFrom: " + billFrom.getAmount());
        accountService.update(accountTo);
        System.out.println("BillTo: " + billTo.getAmount());
        System.out.println("Success");
    }

    private Bill findDefaultBill(Account account) {
        return account.getBills().stream()
                .filter(Bill::getDefault)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No default bill found for account with id: "
                                                             + account.getAccountId()));
    }
}
