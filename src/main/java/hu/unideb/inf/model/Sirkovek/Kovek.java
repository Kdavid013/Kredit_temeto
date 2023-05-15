package hu.unideb.inf.model.Sirkovek;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Kovek implements Serializable {
    @Id
    private String nev;
    private int ar;

    public Kovek() {

    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    @Override
    public String toString() {
        return "Kovek{" +
                "nev='" + nev + '\'' +
                ", ar=" + ar +
                '}';
    }
}
