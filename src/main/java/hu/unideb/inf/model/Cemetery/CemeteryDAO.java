package hu.unideb.inf.model.Cemetery;

import hu.unideb.inf.model.Sirkovek.Kovek;
import hu.unideb.inf.model.Sirkovek.SirKoves;
import hu.unideb.inf.model.Sirkovek.Urnak;

import java.util.List;

public interface CemeteryDAO extends AutoCloseable {

    //Temetkezési vállalkozó adatintézés
    public void saveTemetkezesiVallalkozo(TemetkezesiVallalkozo tv);
    public void deleteTemetkezesiVallalkozo(TemetkezesiVallalkozo tv);
    public void updateTemetkezesiVallalkozo(TemetkezesiVallalkozo tv);
    public List<TemetkezesiVallalkozo> getTV();






}
