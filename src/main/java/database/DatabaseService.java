package database;

import jakarta.persistence.*;

public class DatabaseService {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");

    public void createAccount(String owner, double initialBalance) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = null;
        try (em) {
            transaction = em.getTransaction();
            transaction.begin();
            BankAccount account = new BankAccount(owner, initialBalance);
            em.persist(account);
            transaction.commit();
        } catch (Exception e) {
            assert transaction != null;
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public BankAccount getAccountById(Long accountId) {
        EntityManager em = emf.createEntityManager();
        try (em) {
            return em.find(BankAccount.class, accountId);
        }
    }
}