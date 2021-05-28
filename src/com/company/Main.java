//Created by Javin Liu
//Used to estimate monthly payment of mortgage and other factors.

package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Scanner to take user input
        Scanner in = new Scanner(System.in);

        //Welcome
        System.out.print("WELCOME TO THE MORTGAGE CALCULATOR!\nGET AN ESTIMATE ON THE COSTS OF GETTING A NEW HOME!\n");

        //Get principal loan amount
        System.out.print("Enter the principal loan amount: $");
        double principalLoanAmount = in.nextDouble();
        //Get monthly interest rate
        System.out.print("Enter your interest rate: %");
        double monthlyInterestRate = in.nextDouble();
        //Get months of payment
        System.out.print("How many months of payment are over the loans lifetime: ");
        double numberOfPayments = in.nextDouble();
        //Get how much is down payment
        System.out.print("What percentage is the down payment: %");
        double downPayment = in.nextDouble();
        //Get property tax
        System.out.print("Property tax: $");
        double propertyTax = in.nextDouble();
        //Get HOA fees
        System.out.print("HOA fees: $");
        double HOAFees = in.nextDouble();

        //Convert the percentage into a decimal
        monthlyInterestRate = (monthlyInterestRate / 100) / 12;

        //Calculate total month mortgage payment
        double totalMonthlyMortgagePayment = (principalLoanAmount * (1 -(downPayment / 100))) * ((monthlyInterestRate * (Math.pow((1 + monthlyInterestRate),numberOfPayments)) / (Math.pow((1 + monthlyInterestRate),numberOfPayments)-1)));

        //Round numbers down to 2 decimals
        totalMonthlyMortgagePayment = (Math.round(totalMonthlyMortgagePayment * 100)) / 100;

        //Output information
        System.out.println("Your initial down payment is: $" + (principalLoanAmount * (downPayment / 100)));
        System.out.println("Your monthly mortgage payment is: $" + (totalMonthlyMortgagePayment));
        System.out.println("\nYour total payment per month estimate is: $" + (totalMonthlyMortgagePayment + propertyTax + HOAFees));
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
