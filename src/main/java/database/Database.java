package database;

import java.util.HashMap;
import java.util.Map;

public class Database {
    private static Database instance = new Database();

    Map<String, Object> accounts = new HashMap<>();

    public void createAccount(String name, double balance) {
        String id = name.toLowerCase().replace(" ", "_");

        if (accounts.containsKey(id)) {
            return;
        }
        // convert id to numeric id
        int accountNumber = Integer.parseInt(String.valueOf(accounts.size() + 1));
        accounts.put(id, new BankAccount(name, balance));
    }

    public BankAccount search(String id) {
        return (BankAccount) accounts.get(id);
    }

    public static Database getInstance() {
        return instance;
    }

    public double updateBalance(String id, double balance) {
        BankAccount account = (BankAccount) accounts.get(id);
        account.setBalance(balance);
        return account.getBalance();
    }

    public void setInstance(Database instance) {
        this.instance = instance;
    }
}
