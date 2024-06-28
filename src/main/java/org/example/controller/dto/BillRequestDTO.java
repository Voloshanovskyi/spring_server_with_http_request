package org.example.controller.dto;

import java.math.BigDecimal;

public class BillRequestDTO {
    private BigDecimal amount;

    private Boolean isDefault;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(final BigDecimal amount) {
        this.amount = amount;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(final Boolean aDefault) {
        isDefault = aDefault;
    }
}
