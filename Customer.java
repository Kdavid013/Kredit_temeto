package org.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Integer id;
    private String nev;
    private String szuletesiHely;
    private LocalDate szuletesiIdo;
    private LocalDate halalIdopontja;
    private String temetkezesiVallalkozo;
    private String sirkoves;

    public Customer(String nev, LocalDate szuletesiIdo, String szuletesiHely, LocalDate halalIdopontja, String temetkezesiVallalkozo, String sirkoves) {
        this.nev = nev;
        this.szuletesiIdo = szuletesiIdo;
        this.szuletesiHely = szuletesiHely;
        this.halalIdopontja = halalIdopontja;
        this.temetkezesiVallalkozo = temetkezesiVallalkozo;
        this.sirkoves = sirkoves;
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

