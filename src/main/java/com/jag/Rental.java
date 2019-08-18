package com.jag;

public class Rental {
    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int rented){
        _movie = movie;
        _daysRented = rented;
    }

    public int getDaysRented(){
        return _daysRented;
    }

    public Movie getMovie(){
        return _movie;
    }

    public double amount() {
        return getMovie().amount(getDaysRented());
    }

    public int renterPoints(int daysRented) {
        return getMovie().renterPoints(daysRented);
    }

}
