package org.example.controller;

import org.example.controller.dto.DepositRequestDTO;
import org.example.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepositController {
    private final DepositService depositService;
    @Autowired
    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }
    @PostMapping("/deposits")
    public String pay(@RequestBody DepositRequestDTO depositRequestDTO) {
        return depositService.pay(depositRequestDTO.getAccountId(), depositRequestDTO.getAmount());
    }
}
