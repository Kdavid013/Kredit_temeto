package hu.unideb.inf.model.Sirkovek;

import javafx.collections.ObservableList;

import java.util.List;

public interface SirkovekDAO extends AutoCloseable{

    //Sírköves adatintézés

    public void saveSirkove(SirKoves sk);
    public void deleteSirkoves(SirKoves sk);
    public void updateSirkoves(SirKoves sk);

    public ObservableList<SirKoves> getSK();

    //Sirkovek adatintézés
    public void saveKovek(Kovek k);
    public void deleteKovek(Kovek k);
    public void updateKovek(Kovek k);

    public SirKoves getSirkoves(String SirkovesNev);

    public ObservableList<Kovek> getK();

    //Urnak adatintézés
    public void saveUrnak(Urnak u);
    public void deleteUrnak(Urnak u);
    public void updateUrnak(Urnak u);
    public ObservableList<Urnak> getU();

}
