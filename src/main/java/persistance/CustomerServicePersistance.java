package persistance;

import model.Customer;
import model.account.Account;
import services.CustomerService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class CustomerServicePersistance implements CustomerService{

    private EntityManagerFactory entityManagerFactory;

    public CustomerServicePersistance(EntityManagerFactory entityManagerFactory){
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public Customer add(Customer customer) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Customer savedCustomer;

        try{

            entityManager.getTransaction().begin();
            savedCustomer = entityManager.merge(customer);
            entityManager.getTransaction().commit();
            return savedCustomer;

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
    public Customer findById(Integer id) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try{
            return entityManager.find( Customer.class, id);
        }finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }

    }

    @Override
    public List<Customer> findAll() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Customer> customerCriteriaQuery = criteriaBuilder.createQuery(Customer.class);

            Root<Customer> root = customerCriteriaQuery.from(Customer.class);
            customerCriteriaQuery.select(root);

            return entityManager.createQuery(customerCriteriaQuery).getResultList();

        }finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }

    }

    @Override
    public Set<Integer> getCustomerIds() {

        List<Customer> customerList = findAll();
        Set<Integer> customerSet = new HashSet<>();

        for (Customer customer : customerList) {
            customerSet.add(customer.getId());
        }

        return customerSet;

    }

    @Override
    public double getBalance(int customerId) {

        Customer customer = findById(customerId);
        List<Account> accountList = customer.getAccounts();
        double balance = 0;

        for (Account account : accountList) {
            balance += account.getBalance();
        }

        return balance;

    }

    @Override
    public Set<Integer> getCustomerAccountNumbers(Integer id) {

        Customer customer = findById(id);
        List<Account> accountList = customer.getAccounts();
        Set<Integer> accountsIdList = new HashSet<>();

        for (Account account : accountList) {
            accountsIdList.add(account.getId());
        }

        return accountsIdList;
    }
}
