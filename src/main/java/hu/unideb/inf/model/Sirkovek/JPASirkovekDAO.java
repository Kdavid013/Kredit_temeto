package hu.unideb.inf.model.Sirkovek;

import hu.unideb.inf.model.Customer.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JPASirkovekDAO implements SirkovekDAO{
    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();
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
    public ObservableList<SirKoves> getSK() {
        ObservableList<SirKoves> sirkovesss = FXCollections.observableArrayList();
        TypedQuery<SirKoves> query = entityManager.createQuery("SELECT sk FROM Sirkoves sk", SirKoves.class);
        List<SirKoves> sirkovess = query.getResultList();
        for(SirKoves sirkoves : sirkovess){
            sirkovesss.add(sirkoves);
        }
        return sirkovesss;
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
    public ObservableList<Kovek> getK() {
        ObservableList<Kovek> kosss = FXCollections.observableArrayList();
        TypedQuery<Kovek> query = entityManager.createQuery("SELECT k FROM Kovek k", Kovek.class);
        List<Kovek> koss = query.getResultList();
        for(Kovek ko : koss){
            kosss.add(ko);
        }
        return kosss;
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
    public ObservableList<Urnak> getU() {

        ObservableList<Urnak> usss = FXCollections.observableArrayList();
        TypedQuery<Urnak> query = entityManager.createQuery("SELECT u FROM Urnak u", Urnak.class);
        List<Urnak> uss = query.getResultList();
        for(Urnak u : uss){
            usss.add(u);
        }
        return usss;
    }
    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }


}
