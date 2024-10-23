package database;

public class BankAccount {
    private final String holder;
    private double balance;
    private final int accountNumber;

    public BankAccount(String name, double balance, int accountNumber) {
        this.holder = name;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public String getHolder() {
        return holder;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
