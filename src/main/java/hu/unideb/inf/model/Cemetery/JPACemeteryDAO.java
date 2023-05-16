package hu.unideb.inf.model.Cemetery;

import hu.unideb.inf.model.Customer.Customer;
import hu.unideb.inf.model.Sirkovek.Kovek;
import hu.unideb.inf.model.Sirkovek.SirKoves;
import hu.unideb.inf.model.Sirkovek.Urnak;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JPACemeteryDAO implements CemeteryDAO {

    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();
    public TemetkezesiVallalkozo getTemetkezesiVallalkozo(String tvNev){
        TypedQuery<TemetkezesiVallalkozo> query = entityManager.createQuery("SELECT tv FROM TemetkezesiVallalkozo tv where tv.nev="+ "'" +tvNev+ "'", TemetkezesiVallalkozo.class);
        TemetkezesiVallalkozo tv = query.getSingleResult();
        return tv;
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
    public ObservableList<TemetkezesiVallalkozo> getTV() {
        ObservableList<TemetkezesiVallalkozo> temetkezesivallalkozasok = FXCollections.observableArrayList();
        TypedQuery<TemetkezesiVallalkozo> query = entityManager.createQuery("SELECT tv FROM TemetkezesiVallalkozo tv", TemetkezesiVallalkozo.class);
        List<TemetkezesiVallalkozo> tvs = query.getResultList();
        for(TemetkezesiVallalkozo tv : tvs){
            temetkezesivallalkozasok.add(tv);
        }
        return temetkezesivallalkozasok;




    }



    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
