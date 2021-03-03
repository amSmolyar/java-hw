package javaBasics.BankAccount;

abstract class Account {
    protected int balance;
    protected String attribute;

    public Account(int balance, String attribute) {
        this.balance = balance;
        this.attribute = attribute;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return this.balance;
    }

    public String getAttribute() {
        return this.attribute;
    }

    public void printOperation(Account account, int amount) {
        if (amount < 0) {
            System.out.println(account.getAttribute() + ": Со счета списана сумма в размере " + amount);
        } else if (amount > 0) {
            System.out.println(account.getAttribute() + ": На счет зачислена сумма в размере " + amount);
        } else {
            System.out.println(account.getAttribute() + ": Операция отменена.");
        }
    }

    public boolean inputTransferAvailable(int amount) {
        return true;
    }

    public abstract void pay(int amount);

    public abstract void transfer(Account account, int amount);

    public abstract void addMoney(int amount);

}
