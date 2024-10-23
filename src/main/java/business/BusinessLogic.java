package business;

import database.Database;

public class BusinessLogic {
    public static boolean makeTransaction(String from, String to, double amount) {
        Database db = Database.getInstance();

        //check if the account exists
        if (db.search(from) == null || db.search(to) == null) {
            return false;
        }

        double fromBalance = db.search(from).getBalance();
        double toBalance = db.search(to).getBalance();

        if (fromBalance < amount) {
            return false;
        }

        db.updateBalance(from, fromBalance - amount);
        db.updateBalance(to, toBalance + amount);
        return true;
    }
}
