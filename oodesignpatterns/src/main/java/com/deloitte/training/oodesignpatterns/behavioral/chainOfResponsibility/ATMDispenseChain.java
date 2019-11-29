package com.deloitte.training.oodesignpatterns.behavioral.chainOfResponsibility;

import java.util.Scanner;

public class ATMDispenseChain {

    private DispenseChain c;

    public ATMDispenseChain() {
        // build dispensers
        this.c = new VerifyTenMultiplierDispenser();
        DispenseChain c2 = new Dollar50Dispenser();
        DispenseChain c3 = new Dollar20Dispenser();
        DispenseChain c4 = new Dollar10Dispenser();
        
        // set the chain of responsibility between dispensers
        c.setNextChain(c2);
        c2.setNextChain(c3);
        c3.setNextChain(c4);
    }

    public static void main(String[] args) {
        ATMDispenseChain atmDispenser = new ATMDispenseChain();
        while (true) {
            int amount = 0;
            System.out.println("Enter amount to dispense");
            Scanner input = new Scanner(System.in);
            amount = input.nextInt();
            
            // process the request
            atmDispenser.c.dispense(new Currency(amount));
        }

    }

}
