package org.example.controller.dto;

import org.example.entity.Account;

import java.util.List;
import java.util.stream.Collectors;

public class AccountResponseDTO {
    private final Long accountId;
    private final String
            name;
    private final String
            email;
    private final List<BillResponseDTO>
            bills;

    public AccountResponseDTO(Account account) {
        accountId = account.getAccountId();
        name = account.getName();
        email = account.getEmail();
        bills = account
                .getBills()
                .stream()
                .map(BillResponseDTO::new)
                .collect(Collectors.toList());

    }

    public AccountResponseDTO(final Long accountId,
                              final String name,
                              final String email,
                              final List<BillResponseDTO> bills) {
        this.accountId = accountId;
        this.name = name;
        this.email = email;
        this.bills = bills;
    }

    public String getName() {
        return name;
    }

    public Long getAccountId() {
        return accountId;
    }

    public String getEmail() {
        return email;
    }

    public List<BillResponseDTO> getBills() {
        return bills;
    }
}
