package model;

import java.util.Date;
import java.util.Objects;

public class Isplata extends Transakcija{
    String kategorija;

    public Isplata(int iznos, String primalac, String datum, String tip, String kategorija) {
        super(iznos, primalac, datum, tip);
        this.kategorija = kategorija;
        tip = "ISPLATA";
    }


    public String getKategorija() {
        return kategorija;
    }

    @Override
    public String toString() {
        return  kategorija + " (broj placanja): " + getIznos() + " RSD";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Isplata isplata = (Isplata) o;
        return Objects.equals(kategorija, isplata.kategorija);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), kategorija);
    }
}
