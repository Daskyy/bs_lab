package presentation;

import business.BusinessLogic;

public class Presentation {

    public static boolean makeTransaction(String from, String to, double amount) {
        return BusinessLogic.makeTransaction(from, to, amount);
    }
}
