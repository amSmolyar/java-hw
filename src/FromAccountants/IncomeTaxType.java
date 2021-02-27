package FromAccountants;

public class IncomeTaxType extends TaxType {
    @Override
    public double calculateTaxFor(double amount) {
        return amount * 13 / 100;
    }
}
