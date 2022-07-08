package model;

import java.util.Objects;

public class Pitanje {

    private String tekst;
    private String odgovor;
    private String predmet;


    public Pitanje(String tekst, String odgovor, String predmet) {
        this.tekst = tekst;
        this.odgovor = odgovor;
        this.predmet = predmet;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pitanje pitanje = (Pitanje) o;
        return Objects.equals(tekst, pitanje.tekst) && Objects.equals(predmet, pitanje.predmet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tekst, predmet);
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public String getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(String odgovor) {
        this.odgovor = odgovor;
    }

    public String getPredmet() {
        return predmet;
    }

    public void setPredmet(String predmet) {
        this.predmet = predmet;
    }

    @Override
    public String toString() {
        return tekst + " ";
    }
}
