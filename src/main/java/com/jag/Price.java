package com.jag;

public abstract class Price {

    private int _price;

    public Price(int priceCode) {
        this._price = priceCode;
    }

    abstract double amount(int daysRented);

    public int renterPoints(int daysRented){
        return 1;
    }

}
