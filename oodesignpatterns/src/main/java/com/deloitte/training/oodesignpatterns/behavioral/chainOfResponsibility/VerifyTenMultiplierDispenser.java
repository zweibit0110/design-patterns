package com.deloitte.training.oodesignpatterns.behavioral.chainOfResponsibility;

public class VerifyTenMultiplierDispenser implements DispenseChain {

    private DispenseChain nextChain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void dispense(Currency currency) {
        if (currency.getAmount() % 10 != 0) {
            throw new RuntimeException("Amount should be in multiple of 10s.");
        } else {
            nextChain.dispense(currency);
        }
    }

}
