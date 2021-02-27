package FromAccountants;

public class VATaxType extends TaxType {
    @Override
    public double calculateTaxFor(double amount) {
        return amount * 18 / 100;
    }
}
