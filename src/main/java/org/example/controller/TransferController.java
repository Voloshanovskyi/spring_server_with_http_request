package org.example.controller;

import org.example.controller.dto.TransferRequestDTO;
import org.example.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {
    private final TransferService transferService;
    @Autowired
    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }
    @PostMapping("/transfers")
    public ResponseEntity<String> transfer(@RequestBody TransferRequestDTO transferRequestDTO) {
        try {
            transferService.transfer(
                    transferRequestDTO.getAccountIdFrom(),
                    transferRequestDTO.getAccountIdTo(),
                    transferRequestDTO.getAmount()
            );
            return ResponseEntity.ok("Success");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
}