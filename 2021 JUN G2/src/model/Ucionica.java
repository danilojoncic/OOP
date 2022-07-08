package model;

import java.util.Objects;

public class Ucionica {
    private String naziv;
    private int kapacitet;


    @Override
    public String toString() {
        return naziv + " broj mesta:" + kapacitet;
    }

    public Ucionica(String naziv, int kapacitet) {
        this.naziv = naziv;
        this.kapacitet = kapacitet;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ucionica ucionica = (Ucionica) o;
        return Objects.equals(naziv, ucionica.naziv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naziv);
    }
}
