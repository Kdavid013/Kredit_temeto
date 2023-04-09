package org.example;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Urnak implements Serializable {
    @Id
    private String Urnak;
    private int ar;

    public Urnak(String urnak, int ar) {
        Urnak = urnak;
        this.ar = ar;
    }

    public String getUrnak() {
        return Urnak;
    }

    public void setUrnak(String urnak) {
        Urnak = urnak;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }
}
