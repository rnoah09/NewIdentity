package com.example.newidentity;

public class CreditCard {

    private String expiration;
    private String number;
    private int pin;
    private int security;

    public CreditCard() {
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getSecurity() {
        return security;
    }

    public void setSecurity(int security) {
        this.security = security;
    }




}
