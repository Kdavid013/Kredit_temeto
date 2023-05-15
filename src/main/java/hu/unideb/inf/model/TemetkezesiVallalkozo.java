package hu.unideb.inf.model;

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
    private String temetesitipus;

    public TemetkezesiVallalkozo(String nev, String elerhetoseg, String cim, String temetesitipus) {
        this.nev = nev;
        this.cim = cim;
        this.elerhetoseg = elerhetoseg;
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

    public String getTemetesitipus() {
        return temetesitipus;
    }

    public void setTemetesitipus(String temetesitipus) {
        this.temetesitipus = temetesitipus;
    }

    @Override
    public String toString() {
        return "TemetkezesiVallalkozo{" +
                "nev='" + nev + '\'' +
                ", elerhetoseg='" + elerhetoseg + '\'' +
                ", cim='" + cim + '\'' +
                ", temetesitipus=" + temetesitipus +
                '}';
    }
}
