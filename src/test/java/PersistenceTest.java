import database.BankAccount;
import database.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class PersistenceTest {

    private EntityManagerFactory emf;
    private EntityManager em;

    @BeforeEach
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        em = emf.createEntityManager();
    }

    @Test
    public void testBankAccountPersistence() {
        em.getTransaction().begin();

        BankAccount BankAccount = new BankAccount("John Doe", 1000.0);
        em.persist(BankAccount);

        em.getTransaction().commit();

        BankAccount foundBankAccount = em.find(BankAccount.class, BankAccount.getAccountNumber());
        assertNotNull(foundBankAccount);
        assertEquals("John Doe", foundBankAccount.getHolder());
        assertEquals(1000.0, foundBankAccount.getBalance());
    }

    @Test
    public void testTransactionPersistence() {
        em.getTransaction().begin();

        BankAccount sender = new BankAccount("John Doe", 1000.0);
        BankAccount recipient = new BankAccount("Jane Doe", 1000.0);
        em.persist(sender);
        em.persist(recipient);

        Transaction transaction = new Transaction(sender, recipient, 200.0, new Date());
        em.persist(transaction);

        em.getTransaction().commit();

        Transaction foundTransaction = em.find(Transaction.class, transaction.getId());
        assertNotNull(foundTransaction);
        assertEquals(200.0, foundTransaction.getAmount());
        assertEquals(sender.getAccountNumber(), foundTransaction.getSender().getAccountNumber());
        assertEquals(recipient.getAccountNumber(), foundTransaction.getReceiver().getAccountNumber());
    }
}