package BankAccount;

public class BankAccount {
    public static void main(String[] args) {
        Account check = new CheckingAccount(200);
        Account credit = new CreditAccount(-100);
        Account save = new SavingsAccount(400);

        System.out.println("\n========== CheckingAccount ===========");
        check.addMoney(100);
        check.pay(-50);
        check.pay(50);
        check.transfer(save, 100);
        check.transfer(credit, 200);

        System.out.println("\n========== CreditAccount ===========");
        credit.pay(400);

        credit.transfer(save, 20);
        credit.addMoney(100);

        System.out.println("\n========== SavingsAccount ===========");
        save.pay(15);
        save.transfer(credit, 500);
        save.transfer(credit, 200);
        save.addMoney(130);
    }
}
