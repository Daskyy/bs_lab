import database.BankAccount;
import database.Database;
import presentation.Presentation;

public class Main {

    public static void main(String[] args) {
        Database db = Database.getInstance();
        db.createAccount("John Doe", 1000);
        db.createAccount("Jane Doe", 1000);
        BankAccount john = db.search("john_doe");
        BankAccount jane = db.search("jane_doe");
        System.out.println("John's balance: " + john.getBalance());
        System.out.println("Jane's balance: " + jane.getBalance());
        db.updateBalance("john_doe", 500);
        db.updateBalance("jane_doe", 1500);
        System.out.println("John's balance: " + john.getBalance());
        System.out.println("Jane's balance: " + jane.getBalance());
        Presentation.makeTransaction("john_doe", "jane_doe", 200);
        System.out.println("John's balance: " + john.getBalance());
        System.out.println("Jane's balance: " + jane.getBalance());


    }
}
