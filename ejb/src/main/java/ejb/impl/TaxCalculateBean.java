package ejb.impl;

import ejb.remort.Tax;
import jakarta.ejb.Stateless;

@Stateless
public class TaxCalculateBean implements Tax {
    @Override
    public double calculate(double amount, double rate) {
        return (amount * rate);
    }
}
