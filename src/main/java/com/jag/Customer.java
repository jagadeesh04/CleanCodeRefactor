package com.jag;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name){
        this._name = name;
    }

    public void addRental(Rental rental){
        _rentals.addElement(rental);
    }

    public String getName(){
        return _name;
    }

    public String statement(){
        double totalAmount = 0;
        int frequentRentalsPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for "+getName() + "\n";

        while (rentals.hasMoreElements()){
            Rental each = (Rental) rentals.nextElement();

            double thisAmount = 0;
            // determines the amount for each line
            switch (each.getMovie().getPriceCode()){
                case Movie.REGULAR:
                thisAmount +=2;
                    if(each.getDaysRented() >2)
                        thisAmount += (each.getDaysRented()-2)*1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented()*3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount +=1.5;
                    if(each.getDaysRented()>3)
                        thisAmount += (each.getDaysRented() -3)*1.5;
                    break;
            }
            //add frequent renter points
            frequentRentalsPoints++;

            // add bonus for a two day new release rental
            if(each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDaysRented()>1)
                frequentRentalsPoints++;

            // show figures for this rental
            result += "\t" +each.getMovie().getTitle()+"\t"+String.valueOf(thisAmount)+"\n";
            totalAmount += thisAmount;
        }

        // add footer lines
        result += "You owed "+String.valueOf(totalAmount) +"\n";
        result += "You earned "+String.valueOf(frequentRentalsPoints)+" frequent renter points";

        return result;
    }

}
