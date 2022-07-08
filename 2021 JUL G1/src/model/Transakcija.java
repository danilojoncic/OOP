package model;

import java.util.Date;
import java.util.Objects;

public class Transakcija {
    private int iznos;
    private String primalac;
    private String datum;
    private String tip;


    public Transakcija(int iznos, String primalac, String datum, String tip) {
        this.iznos = iznos;
        this.primalac = primalac;
        this.datum = datum;
        this.tip = tip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transakcija that = (Transakcija) o;
        return Objects.equals(primalac, that.primalac) && Objects.equals(datum, that.datum) && Objects.equals(tip, that.tip);
    }




    @Override
    public int hashCode() {
        return Objects.hash(primalac, datum, tip);
    }

    public int getIznos() {
        return iznos;
    }

    public String getPrimalac() {
        return primalac;
    }

    public String getDatum() {
        return datum;
    }

    public String getTip() {
        return tip;
    }
}
