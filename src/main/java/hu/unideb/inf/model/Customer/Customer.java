package hu.unideb.inf.model.Customer;

import hu.unideb.inf.model.Sirkovek.SirKoves;
import hu.unideb.inf.model.Cemetery.TemetkezesiVallalkozo;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Customer implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String nev;
    private String szuletesiHely;
    private LocalDate szuletesiIdo;
    private LocalDate halalIdopontja;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Temetkezesi_Vallalkozo")
    private TemetkezesiVallalkozo temetkezesiVallalkozo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Sirkoves")
    private SirKoves sirkoves;

    public Customer() {

    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public LocalDate getSzuletesiIdo() {
        return szuletesiIdo;
    }

    public void setSzuletesiIdo(LocalDate szuletesiIdo) {
        this.szuletesiIdo = szuletesiIdo;
    }

    public String getSzuletesiHely() {
        return szuletesiHely;
    }

    public void setSzuletesiHely(String szuletesiHely) {
        this.szuletesiHely = szuletesiHely;
    }

    public LocalDate getHalalIdopontja() {
        return halalIdopontja;
    }

    public void setHalalIdopontja(LocalDate halalIdopontja) {
        this.halalIdopontja = halalIdopontja;
    }

    public TemetkezesiVallalkozo getTemetkezesiVallalkozo() {
        return temetkezesiVallalkozo;
    }

    public void setTemetkezesiVallalkozo(TemetkezesiVallalkozo temetkezesiVallalkozo) {
        this.temetkezesiVallalkozo = temetkezesiVallalkozo;
    }

    public SirKoves getSirkoves() {
        return sirkoves;
    }

    public void setSirkoves(SirKoves sirkoves) {
        this.sirkoves = sirkoves;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", nev='" + nev + '\'' +
                ", szuletesiHely='" + szuletesiHely + '\'' +
                ", szuletesiIdo=" + szuletesiIdo +
                ", halalIdopontja=" + halalIdopontja +
                ", temetkezesiVallalkozo=" + temetkezesiVallalkozo +
                ", sirkoves=" + sirkoves +
                '}';
    }

    public Integer getId() {
        return id;
    }
}
