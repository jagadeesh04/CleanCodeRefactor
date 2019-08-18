package com.jag;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String _name;
    private List<Rental> _rentals = new ArrayList();

    public Customer(String name){
        this._name = name;
    }

    public void addRental(Rental rental){

        _rentals.add(rental);
    }

    public String getName(){
        return _name;
    }

    public String statement(){

        String result = result(this._rentals);

        double totalAmount = totalAmount(this._rentals);

        int frequentRentalsPoints = frequentRentalsPoints(this._rentals);

        return footer(result, totalAmount, frequentRentalsPoints);
    }

    private String result(Iterable<Rental>  rentals) {
        String name  = getName();
        String result = header(name);
        for(Rental each: rentals){
            double thisAmount = each.amount();
            result += "\t" +each.getMovie().getTitle()+"\t"+String.valueOf(thisAmount)+"\n";
        }
        return result;
    }

    private double totalAmount(Iterable<Rental>  rentals) {
        double totalAmount = 0;
        for(Rental each: rentals){
            double thisAmount = each.amount();
            totalAmount += thisAmount;
        }
        return totalAmount;
    }

    private int frequentRentalsPoints(List<Rental> myRentals1) {
        int totalRenterPoints = 0;
        for(Rental each: myRentals1){
            totalRenterPoints += each.renterPoints(each.getDaysRented());
        }
        return totalRenterPoints;
    }

    private String header(String name) {
        return "Rental Record for "+name+ "\n";
    }

    private String footer(String result, double totalAmount, int frequentRentalsPoints) {
        String footer1 ="You owed "+String.valueOf(totalAmount) +"\n";
        String footer2 = "You earned "+String.valueOf(frequentRentalsPoints)+" frequent renter points";

        return result+footer1+footer2;
    }

}
