package hu.unideb.inf.model.Sirkovek;

import org.hibernate.annotations.Cascade;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import java.io.Serializable;
import java.util.List;

@Entity
public class SirKoves implements Serializable {
    @Id
    private String nev;
    private String elerhetoseg;
    private String cim;
    @JoinTable
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @ElementCollection(targetClass = Kovek.class)
    private List<Kovek> kovek;
    @JoinTable
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @ElementCollection(targetClass = Urnak.class)
    private List<Urnak> urnak;

    public SirKoves() {

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

    @Override
    public String toString() {
        return "SirKoves{" +
                "nev='" + nev + '\'' +
                ", elerhetoseg='" + elerhetoseg + '\'' +
                ", cim='" + cim + '\'' +
                ", kovek=" + kovek +
                ", urnak=" + urnak +
                '}';
    }
}
