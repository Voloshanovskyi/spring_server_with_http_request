package org.example.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public class DepositRequestDTO {
    @JsonProperty("account_id")
    private Long accountId;
    @JsonProperty("amount")
    private BigDecimal amount;
    public Long getAccountId() {
        return accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
