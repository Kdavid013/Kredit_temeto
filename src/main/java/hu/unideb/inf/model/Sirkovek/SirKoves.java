package hu.unideb.inf.model.Sirkovek;

import hu.unideb.inf.model.Customer.Customer;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SirKoves implements Serializable {
    @Id
    private String nev;
    private String elerhetoseg;
    private String cim;
    private String kovek;
    private String urnak;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Sirkoves")
    private List<Customer> customers = new ArrayList<>();

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

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

    public String getKovek() {
        return kovek;
    }

    public void setKovek(String kovek) {
        this.kovek = kovek;
    }

    public String getUrnak() {
        return urnak;
    }

    public void setUrnak(String urnak) {
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
