package javaBasics.FromAccountants;

public class ProgressiveTaxType extends TaxType {
    @Override
    public double calculateTaxFor(double amount) {
        if (amount < 100000)
            return amount * 10 / 100;
        else
            return amount * 15 / 100;
    }
}
