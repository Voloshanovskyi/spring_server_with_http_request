package org.example.controller.dto;

import org.example.entity.Bill;

import java.math.BigDecimal;

public class BillResponseDTO {
    private Long billId;

    private BigDecimal amount;

    private Boolean isDefault;
    public BillResponseDTO(Bill bill){
        billId = bill.getBillId();
        amount = bill.getAmount();
        isDefault = bill.getDefault();

    }

    public BillResponseDTO(final Long billId,
                           final BigDecimal amount,
                           final Boolean isDefault) {
        this.billId = billId;
        this.amount = amount;
        this.isDefault = isDefault;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(final Long billId) {
        this.billId = billId;
    }

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
