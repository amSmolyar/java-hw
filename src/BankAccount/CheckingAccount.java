package BankAccount;

public class CheckingAccount extends Account {

    public CheckingAccount(int balance) {
        super(balance, "расчетный");
        if (this.balance < 0)
            System.out.println(this.attribute + ": Расчетный счет не может иметь отрицательный баланс!");
    }

    @Override
    public void pay(int amount) {
        System.out.println("\n" + this.attribute + ": Требуется оплатить покупку на сумму " + amount);
        if (amount <= 0) {
            System.out.println(this.attribute + ": Сумма платежа должна быть положительной!");
            return;
        } else if (amount > balance) {
            System.out.println(this.attribute + ": Сумма превышает баланс!");
            return;
        }

        balance -= amount;
        System.out.println(this.attribute + ": Платеж в размере " + amount + " прошел успешно. Баланс расчетного счета: " + balance);
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
                ": Требуется положить на счет (снять со счета) следующую сумму: " + amount);
        if ((amount < 0) && (Math.abs(amount) > balance)) {
            System.out.println(this.attribute + ": Операция не может быть выполнена! Баланс: " + balance);
        } else {
            balance += amount;
            printOperation(this, amount);
            System.out.println(this.attribute + ": Баланс расчетного счета: " + balance);
        }

    }

}
