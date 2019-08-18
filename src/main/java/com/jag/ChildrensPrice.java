package com.jag;

public class ChildrensPrice extends Price {
    public ChildrensPrice() {
        super(Movie.CHILDRENS);
    }

    public double amount(int daysRented) {
        double thisAmount = 0;

        thisAmount +=1.5;
        if(daysRented >3)
            thisAmount += (daysRented -3)*1.5;
        return thisAmount;
    }
}
