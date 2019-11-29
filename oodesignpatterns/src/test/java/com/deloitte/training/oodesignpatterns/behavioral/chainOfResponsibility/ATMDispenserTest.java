package com.deloitte.training.oodesignpatterns.behavioral.chainOfResponsibility;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ATMDispenserTest {

    private DispenseChain verifier;

    private DispenseChain dollar50Dispenser;

    private DispenseChain dollar20Dispenser;

    private DispenseChain dollar10Dispenser;

    @Before
    public void setup() {
        verifier = new VerifyTenMultiplierDispenser();
        dollar50Dispenser = mock(Dollar50Dispenser.class);
        dollar20Dispenser = mock(Dollar20Dispenser.class);
        dollar10Dispenser = mock(Dollar10Dispenser.class);

        verifier.setNextChain(dollar50Dispenser);
        dollar50Dispenser.setNextChain(dollar20Dispenser);
        dollar20Dispenser.setNextChain(dollar10Dispenser);
    }

    @Test(expected = RuntimeException.class)
    public void cannotDispenseAmountIfNotMultipleOfTen() {
        verifier.dispense(new Currency(111));
    }

    @Test
    @Ignore
    public void dispenseAmountUsingAllDispensers() {
        Currency currency = new Currency(50 + 20 + 10);
        verifier.dispense(currency);
        verify(dollar50Dispenser, times(1)).dispense(currency);
        verify(dollar20Dispenser, times(1)).dispense(currency);
        verify(dollar10Dispenser, times(1)).dispense(currency);
    }

    @Test
    public void dispenseAmountUsingOneDispenser() {
        Currency currency = new Currency(50 * 3);
        verifier.dispense(currency);
        verify(dollar50Dispenser, times(1)).dispense(currency);
        verify(dollar20Dispenser, times(0)).dispense(currency);
        verify(dollar10Dispenser, times(0)).dispense(currency);
    }
    
}
