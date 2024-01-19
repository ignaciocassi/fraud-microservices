package com.ignaciocassi.customer;

public class FraudException extends RuntimeException{
    public FraudException(String message){
        super(message);
    }
}
