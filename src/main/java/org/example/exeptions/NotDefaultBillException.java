package org.example.exeptions;

public class NotDefaultBillException extends RuntimeException {
    public NotDefaultBillException(String message){
        super(message);
    }
}
