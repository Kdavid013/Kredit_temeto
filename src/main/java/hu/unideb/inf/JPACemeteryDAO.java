package hu.unideb.inf;

import hu.unideb.inf.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JPACemeteryDAO implements CemeteryDAO {

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
    public List<Customer> getCustomer() {
        TypedQuery<Customer> query = entityManager.createQuery("SELECT c FROM Customer c", Customer.class);
        List<Customer> customers = query.getResultList();
        return customers;
    }

    @Override
    public void saveTemetkezesiVallalkozo(TemetkezesiVallalkozo tv) {
        entityManager.getTransaction().begin();
        entityManager.persist(tv);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteTemetkezesiVallalkozo(TemetkezesiVallalkozo tv) {
        entityManager.getTransaction().begin();
        entityManager.remove(tv);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateTemetkezesiVallalkozo(TemetkezesiVallalkozo tv) {
        saveTemetkezesiVallalkozo(tv);
    }

    @Override
    public List<TemetkezesiVallalkozo> getTV() {
        TypedQuery<TemetkezesiVallalkozo> query = entityManager.createQuery("SELECT tv FROM TemetkezesiVallalkozo tv", TemetkezesiVallalkozo.class);
        List<TemetkezesiVallalkozo> tvs = query.getResultList();
        return tvs;
    }

    @Override
    public void saveSirkove(SirKoves sk) {
        entityManager.getTransaction().begin();
        entityManager.persist(sk);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteSirkoves(SirKoves sk) {
        entityManager.getTransaction().begin();
        entityManager.remove(sk);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateSirkoves(SirKoves sk) {
        saveSirkove(sk);
    }

    @Override
    public List<SirKoves> getSK() {
        TypedQuery<SirKoves> query = entityManager.createQuery("SELECT sk FROM Sirkoves sk", SirKoves.class);
        List<SirKoves> sks = query.getResultList();
        return sks;
    }

    @Override
    public void saveKovek(Kovek k) {
        entityManager.getTransaction().begin();
        entityManager.persist(k);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteKovek(Kovek k) {
        entityManager.getTransaction().begin();
        entityManager.remove(k);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateKovek(Kovek k) {
        saveKovek(k);
    }

    @Override
    public List<Kovek> getK() {
        TypedQuery<Kovek> query = entityManager.createQuery("SELECT k FROM Kovek k", Kovek.class);
        List<Kovek> kovek = query.getResultList();
        return kovek ;
    }

    @Override
    public void saveUrnak(Urnak u) {
        entityManager.getTransaction().begin();
        entityManager.persist(u);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteUrnak(Urnak u) {
        entityManager.getTransaction().begin();
        entityManager.remove(u);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateUrnak(Urnak u) {
        saveUrnak(u);
    }

    @Override
    public List<Urnak> getU() {
        TypedQuery<Urnak> query = entityManager.createQuery("SELECT u FROM Urnak u", Urnak.class);
        List<Urnak> urnak = query.getResultList();
        return urnak;
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
