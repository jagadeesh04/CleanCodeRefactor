package com.jag;

public class NewReleasePrice extends Price{
    public NewReleasePrice(){
        super(Movie.NEW_RELEASE);
    }

    public double amount(int daysRented) {
        double thisAmount = 0 + daysRented * 3;

        return thisAmount;
    }

    public int renterPoints(int daysRented) {
        return  daysRented >1 ? 2: 1;
    }
}
