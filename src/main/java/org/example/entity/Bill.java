package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.example.controller.dto.BillRequestDTO;

import java.math.BigDecimal;

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long billId;

    private BigDecimal amount;

    private Boolean isDefault;

    public Bill(final BigDecimal amount, final Boolean isDefault) {
        this.amount = amount;
        this.isDefault = isDefault;
    }

    public Bill() {
    }

    public Bill(BillRequestDTO billRequestDTO) {
        amount = billRequestDTO.getAmount();
        isDefault = billRequestDTO.getDefault();
    }

    public Long getBillId() {
        return billId;
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

    @Override
    public String toString() {
        return "Bill{" + "billId=" + billId +
               ", amount=" + amount +
               ", isDefault=" + isDefault +
               '}';
    }
}
