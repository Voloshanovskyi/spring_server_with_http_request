package org.example.service;

import org.example.entity.Account;
import org.example.entity.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import static org.example.utils.AccountUtils.findDefaultBill;
@Service
public class DepositService {
    private final AccountService accountService;
    @Autowired
    public DepositService(AccountService accountService) {
        this.accountService = accountService;
    }
    public String pay(Long accountId, BigDecimal depositAmount){
        Account account = accountService.getById(accountId);
        Bill defaultBill = findDefaultBill(account);
        defaultBill.setAmount(defaultBill.getAmount().add(depositAmount));
        accountService.update(account);
        return "Success";
    }
}
