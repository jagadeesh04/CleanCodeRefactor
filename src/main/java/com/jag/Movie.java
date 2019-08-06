package com.jag;

public class Movie {

    private String _title;
    private int _priceCode;

    public static final int  CHILDRENS = 2;
    public static final int  REGULAR = 0;
    public static final int  NEW_RELEASE = 1;

    public Movie(String name, int priceCode) {
        _title = name;
        _priceCode = priceCode;
    }

    public String getTitle(){
        return _title;
    }

    public int getPriceCode(){
        return _priceCode;
    }

}
