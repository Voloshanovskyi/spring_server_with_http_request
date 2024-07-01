package org.example.utils;

import org.example.entity.Account;
import org.example.entity.Bill;
import org.example.exeptions.NotDefaultBillException;

public class AccountUtils {
    public static Bill findDefaultBill(Account accountFrom) {
        return accountFrom.getBills()
                .stream()
                .filter(Bill::getDefault)
                .findAny()
                .orElseThrow(() -> new NotDefaultBillException(
                        "Unable to find bill for account with id: "
                        + accountFrom.getAccountId()));
    }
}
