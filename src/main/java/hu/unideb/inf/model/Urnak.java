package hu.unideb.inf.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Urnak implements Serializable {
    @Id
    private String nev;
    private int ar;

    public Urnak(String nev, int ar) {
        this.nev = nev;
        this.ar = ar;
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
        return "Urnak{" +
                "nev='" + nev + '\'' +
                ", ar=" + ar +
                '}';
    }
}
