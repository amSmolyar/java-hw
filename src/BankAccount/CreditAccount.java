package BankAccount;

public class CreditAccount extends Account {

    public CreditAccount(int balance) {
        super(balance, "кредитный");
        if (this.balance > 0)
            System.out.println(this.attribute + ": Кредитный счет не может иметь положительный баланс!");
    }

    @Override
    public boolean inputTransferAvailable(int amount) {
        int newBalance = balance + amount;
        if ((amount <= 0) || (newBalance > 0))
            return false;
        return true;
    }

    @Override
    public void pay(int amount) {
        System.out.println("\n" + this.attribute + ": Требуется оплатить покупку на сумму " + amount);
        if (amount <= 0) {
            System.out.println(this.attribute + ": Сумма платежа должна быть положительной!");
            return;
        }

        balance -= amount;
        System.out.println(this.attribute + ": Платеж в размере " + amount + " прошел успешно. Баланс кредитного счета: " + balance);
    }

    @Override
    public void transfer(Account account, int amount) {
        System.out.println("\n" + this.attribute +
                ": Требуется перевести на " + account.getAttribute() + " счет следующую сумму: " + amount);

        if ((amount <= 0) || (!account.inputTransferAvailable(amount))) {
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
        if (amount > Math.abs(balance)) {
            System.out.println(this.attribute + ": Операция не может быть выполнена! Баланс: " + balance);
        } else {
            balance += amount;
            printOperation(this, amount);
            System.out.println(this.attribute + ": Баланс кредитного счета: " + balance);
        }


    }
}
