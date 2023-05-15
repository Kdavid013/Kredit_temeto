package hu.unideb.inf;

import hu.unideb.inf.model.*;

import java.util.List;

public interface CemeteryDAO extends AutoCloseable {
    //A Customer adatintézés
    public void saveCustomer(Customer c);
    public void deleteCustomer(Customer c);
    public void updateCustomer(Customer c);
    public List<Customer> getCustomer();

    //Temetkezési vállalkozó adatintézés
    public void saveTemetkezesiVallalkozo(TemetkezesiVallalkozo tv);
    public void deleteTemetkezesiVallalkozo(TemetkezesiVallalkozo tv);
    public void updateTemetkezesiVallalkozo(TemetkezesiVallalkozo tv);
    public List<TemetkezesiVallalkozo> getTV();

    //Sírköves adatintézés

    public void saveSirkove(SirKoves sk);
    public void deleteSirkoves(SirKoves sk);
    public void updateSirkoves(SirKoves sk);

    public List<SirKoves> getSK();

    //Sirkovek adatintézés
    public void saveKovek(Kovek k);
    public void deleteKovek(Kovek k);
    public void updateKovek(Kovek k);

    public List<Kovek> getK();

    //Urnak adatintézés
    public void saveUrnak(Urnak u);
    public void deleteUrnak(Urnak u);
    public void updateUrnak(Urnak u);
    public List<Urnak> getU();
}
