package javaBasics.BankAccount;

public class SavingsAccount extends Account {

    public SavingsAccount(int balance) {
        super(balance, "сберегательный");
        if (this.balance < 0)
            System.out.println(this.attribute + ": Сберегательный счет не может иметь отрицательный баланс!");
    }

    @Override
    public void pay(int amount) {
        System.out.println("\n" + this.attribute + ": Требуется оплатить покупку на сумму " + amount);
        System.out.println(this.attribute + ": Со сберегательного счета нельзя платить!");
    }

    @Override
    public void transfer(Account account, int amount) {
        System.out.println("\n" + this.attribute +
                ": Требуется перевести на " + account.getAttribute() + " счет следующую сумму: " + amount);

        if ((amount <= 0) || (amount > balance) || (!account.inputTransferAvailable(amount))) {
            System.out.println(this.attribute + ": Операция не может быть выполнена!");
            return;
        }

        account.addMoney(amount);
        System.out.println(this.attribute + ": На " + account.getAttribute() + " счет переведена сумма " +
                amount + ". Теперь его баланс составляет " + account.getBalance());
        balance -= amount;
        System.out.println(this.attribute + ": Баланс расчетного счета: " + balance);
    }

    public void addMoney(int amount) {
        System.out.println("\n" + this.attribute +
                ":  Требуется положить на счет (снять со счета) следующую сумму: " + amount);
        if ((amount < 0) && (Math.abs(amount) > balance)) {
            System.out.println(this.attribute + ": Операция не может быть выполнена! Баланс: " + balance);
        } else {
            balance += amount;
            printOperation(this, amount);
            System.out.println(this.attribute + ": Баланс сберегательного счета: " + balance);
        }
    }
}
