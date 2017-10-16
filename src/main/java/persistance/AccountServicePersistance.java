package persistance;

import model.Customer;
import model.account.Account;
import services.AccountService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;

public class AccountServicePersistance implements AccountService{

    private EntityManagerFactory entityManagerFactory;

    public AccountServicePersistance(EntityManagerFactory entityManagerFactory){
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public Account add(Account account) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Account savedAccount;

        try{

            entityManager.getTransaction().begin();
            savedAccount = entityManager.merge(account);
            entityManager.getTransaction().commit();
            return savedAccount;

        }catch (RollbackException e){
            entityManager.getTransaction().rollback();
            return null;
        }finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }

    }

    @Override
    public void deposit(int id, double amount) {

        Account account = findById(id);
        account.credit(amount);

        add(account);

    }

    @Override
    public void withdraw(int id, double amount) {

        Account account = findById(id);
        account.debit(amount);

        add(account);

    }

    @Override
    public void transfer(int srcId, int dstId, double amount) {

        Account accountSrc = findById(srcId);
        Account accountDst = findById(dstId);

        // make sure transaction can be performed
        if (accountSrc.canDebit(amount) && accountDst.canCredit(amount)) {
            accountSrc.debit(amount);
            accountDst.credit(amount);

            add(accountDst);
            add(accountSrc);
        }

    }


    public Account findById(Integer id) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try{
            return entityManager.find( Account.class, id);
        }finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }

    }
}
