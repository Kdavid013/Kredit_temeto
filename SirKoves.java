package org.example;

import javax.persistence.*;
import java.util.*;

@Entity
public class SirKoves {
    @Id
    private String nev;
    private String elerhetoseg;
    private String cim;
    @JoinTable
    @ElementCollection(targetClass = Kovek.class)
    private List<Kovek> kovek;
    @JoinTable
    @ElementCollection(targetClass = Urnak.class)
    private List<Urnak> urnak;

    public SirKoves(String nev, String elerhetoseg, String cim, List<Kovek> kovek, List<Urnak> urnak) {
        this.nev = nev;
        this.elerhetoseg = elerhetoseg;
        this.cim = cim;
        this.kovek = kovek;
        this.urnak = urnak;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getElerhetoseg() {
        return elerhetoseg;
    }

    public void setElerhetoseg(String elerhetoseg) {
        this.elerhetoseg = elerhetoseg;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public List<Kovek> getKovek() {
        return kovek;
    }

    public void setKovek(List<Kovek> kovek) {
        this.kovek = kovek;
    }

    public List<Urnak> getUrnak() {
        return urnak;
    }

    public void setUrnak(List<Urnak> urnak) {
        this.urnak = urnak;
    }
}
