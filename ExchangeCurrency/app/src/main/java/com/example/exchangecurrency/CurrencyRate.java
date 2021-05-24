package com.example.exchangecurrency;

public class CurrencyRate {
    private String id;
    private String currency;

    public CurrencyRate( String currency,String id) {
        this.id = id;
        this.currency = currency;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
