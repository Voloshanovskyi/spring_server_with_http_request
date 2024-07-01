package org.example.controller.dto;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountRequestDTO {
    private final String name;
    private final String email;
    private final List<BillRequestDTO> bills;

    @JsonCreator
    public AccountRequestDTO(@JsonProperty("name") String name, @JsonProperty("email") String email, @JsonProperty("bills") List<BillRequestDTO> bills) {
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
