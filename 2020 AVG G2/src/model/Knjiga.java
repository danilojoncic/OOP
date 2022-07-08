package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Knjiga {
    private int razred;
    private String izdavac;
    private String predmet;
    private String naslov;
    private String autori;


    public Knjiga(int razred, String izdavac, String predmet, String naslov, String autori) {
        this.razred = razred;
        this.izdavac = izdavac;
        this.predmet = predmet;
        this.naslov = naslov;
        this.autori = autori;
    }


    public String getRazred() {
        return razred + ".razred";
    }

    public String getIzdavac() {
        return izdavac;
    }

    public String getPredmet() {
        return predmet;
    }

    public String getNaslov() {
        return naslov;
    }

    public String getAutori() {
        return autori;
    }

    @Override
    public String toString() {
        return getRazred() + "-" + predmet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Knjiga knjiga = (Knjiga) o;
        return razred == knjiga.razred && Objects.equals(izdavac, knjiga.izdavac) && Objects.equals(predmet, knjiga.predmet) && Objects.equals(naslov, knjiga.naslov) && Objects.equals(autori, knjiga.autori);
    }

    @Override
    public int hashCode() {
        return Objects.hash(razred, izdavac, predmet, naslov, autori);
    }
}
