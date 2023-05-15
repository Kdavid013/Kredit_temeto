package hu.unideb.inf.model.Sirkovek;

import java.util.List;

public interface SirkovekDAO extends AutoCloseable{

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
