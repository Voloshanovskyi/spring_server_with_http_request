package org.example.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;

    private String name;

    private String email;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Bill> bills;

    public Long getAccountId() {
        return accountId;
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

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(final List<Bill> bills) {
        this.bills = bills;
    }

    @Override
    public String toString() {
        return "Account{" + "accountId=" + accountId +
               ", name='" + name + '\'' +
               ", email='" + email + '\'' +
               ", bills=" + bills +
               '}';
    }

    public Account() {
    }

    public Account(final String name,
                   final String email,
                   final List<Bill> bills) {
        this.name = name;
        this.email = email;
        this.bills = bills;
    }
}
