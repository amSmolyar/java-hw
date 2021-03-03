package javaBasics.FromAccountants;

public class Main {
    public static void main(String[] args) {
        TaxService taxService = new TaxService();
        Bill[] payments = new Bill[]{
                new Bill(20000, new IncomeTaxType(), taxService),
                new Bill(80000, new VATaxType(), taxService),
                new Bill(90000, new ProgressiveTaxType(), taxService),
                new Bill(120000, new ProgressiveTaxType(), taxService)
        };

        for (int i = 0; i < payments.length; i++) {
            Bill bill = payments[i];
            bill.payTaxes();
        }
    }
}
