package database;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private BankAccount sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private BankAccount receiver;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private LocalDateTime date;

    public Transaction(BankAccount sender, BankAccount receiver, double amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.date = LocalDateTime.now();
    }

    public Transaction() {
    }

    public Long getId() {
        return id;
    }

    public BankAccount getSender() {
        return sender;
    }

    public BankAccount getReceiver() {
        return receiver;
    }

    public void setSender(BankAccount sender) {
        this.sender = sender;
    }

    public void setReceiver(BankAccount receiver) {
        this.receiver = receiver;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
