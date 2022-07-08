package model;

import java.util.Objects;

public class Zanimanje {
    private String naziv;
    private double koeficijent;
    private int brojZaposlenih = 0;
    private double ukupnaPlata = 0;

    public Zanimanje(String naziv, double koeficijent) {
        this.naziv = naziv;
        this.koeficijent = koeficijent;
    }

    public Zanimanje(String naziv) {
        this.naziv = naziv;
    }

    public int getBrojZaposlenih() {
        return brojZaposlenih;
    }

    public double getUkupnaPlata() {
        return ukupnaPlata;
    }

    public String getNaziv() {
        return naziv;
    }

    public double getKoeficijent() {
        return koeficijent;
    }


    @Override
    public String toString() {
        return naziv + "("+ brojZaposlenih + ") - " + ukupnaPlata;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zanimanje zanimanje = (Zanimanje) o;
        return Objects.equals(naziv, zanimanje.naziv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naziv);
    }
}
