package com.ignaciocassi.customer;

public class FraudCheckResponse {
    private boolean isFraudster;

    public FraudCheckResponse() {
        // Default constructor for Jackson
    }

    public FraudCheckResponse(boolean isFraudster) {
        this.isFraudster = isFraudster;
    }

    public boolean isFraudster() {
        return isFraudster;
    }

    public void setFraudster(boolean isFraudster) {
        this.isFraudster = isFraudster;
    }
}
