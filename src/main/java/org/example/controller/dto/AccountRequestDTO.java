package org.example.controller.dto;

import java.util.List;

public class AccountRequestDTO {
    private final String name;

    private final String email;
    private final List<BillRequestDTO> bills;

    public AccountRequestDTO(String name, String email, List<BillRequestDTO> bills) {
        this.name = name;
        this.email = email;
        this.bills = bills;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<BillRequestDTO> getBills() {
        return bills;
    }
}
