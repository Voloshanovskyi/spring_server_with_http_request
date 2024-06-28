package org.example.exeptions;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(final String message) {
        super(message);
    }
}
