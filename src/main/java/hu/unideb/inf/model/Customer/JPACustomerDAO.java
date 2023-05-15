package hu.unideb.inf.model.Customer;
import hu.unideb.inf.model.Customer.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JPACustomerDAO implements CustomerDAO {

    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void saveCustomer(Customer c) {
        entityManager.getTransaction().begin();
        entityManager.persist(c);
        entityManager.getTransaction().commit();
    }
    @Override
    public void deleteCustomer(Customer c) {
        entityManager.getTransaction().begin();
        entityManager.remove(c);
        entityManager.getTransaction().commit();
    }
    @Override
    public void updateCustomer(Customer c) {
        saveCustomer(c);
    }

    @Override
    public ObservableList<Customer> getCustomer() {
        ObservableList<Customer> customersss = FXCollections.observableArrayList();
        TypedQuery<Customer> query = entityManager.createQuery("SELECT c FROM Customer c", Customer.class);
        List<Customer> customers = query.getResultList();
        for(Customer customer : customers){
            customersss.add(customer);
        }
        return customersss;
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }

}
