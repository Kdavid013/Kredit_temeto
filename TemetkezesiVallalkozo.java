package org.example;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class TemetkezesiVallalkozo {
    @Id
    private String nev;
    private String elerhetoseg;//?
    private String cim;
    @Enumerated(EnumType.STRING)
    private TemetesiTipus temetesitipus;

    public enum TemetesiTipus {
            Urna,Koporso
    }

    public TemetkezesiVallalkozo(String nev, String elerhetoseg, String cim, TemetesiTipus temetesitipus) {
        this.nev = nev;
        this.elerhetoseg = elerhetoseg;
        this.cim = cim;
        this.temetesitipus = temetesitipus;
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

    public TemetesiTipus getTemetesitipus() {
        return temetesitipus;
    }

    public void setTemetesitipus(TemetesiTipus temetesitipus) {
        this.temetesitipus = temetesitipus;
    }
}
