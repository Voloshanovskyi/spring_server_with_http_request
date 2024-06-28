package org.example.controller.dto;

import org.example.entity.Account;

import java.util.List;
import java.util.stream.Collectors;

public class AccountResponseDTO {
    private Long accountId;

    private String name;

    private String email;
    private List<BillResponseDTO> billS;
    public AccountResponseDTO(Account account){
        accountId = account.getAccountId();
        name = account.getName();
        email = account.getEmail();
        billS = account
                .getBills()
                .stream()
                .map(BillResponseDTO::new)
                .collect(Collectors.toList());

    }
    public AccountResponseDTO(final Long accountId,
                              final String name,
                              final String email,
                              final List<BillResponseDTO> billS) {
        this.accountId = accountId;
        this.name = name;
        this.email = email;
        this.billS = billS;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(final Long accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public List<BillResponseDTO> getBillS() {
        return billS;
    }

    public void setBillS(final List<BillResponseDTO> billS) {
        this.billS = billS;
    }
}
