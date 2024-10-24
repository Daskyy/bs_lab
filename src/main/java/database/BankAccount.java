package database;

import jakarta.persistence.*;

@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNumber;

    @Column(nullable = false)
    private String holder;

    @Column(nullable = false)
    private double balance;

    public BankAccount(String name, double balance) {
        this.holder = name;
        this.balance = balance;
    }

    public BankAccount() {

    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }
}
