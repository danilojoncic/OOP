package model;

import java.util.Date;
import java.util.Objects;

public class Pokusaj implements Comparable<Pokusaj>{
    private String predmet;
    private Date datum;
    private double skor;


    public Pokusaj(String predmet, Date datum, double skor) {
        this.predmet = predmet;
        this.datum = datum;
        this.skor = skor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokusaj pokusaj = (Pokusaj) o;
        return Double.compare(pokusaj.skor, skor) == 0 && Objects.equals(predmet, pokusaj.predmet) && Objects.equals(datum, pokusaj.datum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(predmet, datum, skor);
    }

    public String getPredmet() {
        return predmet;
    }

    public void setPredmet(String predmet) {
        this.predmet = predmet;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public double getSkor() {
        return skor;
    }

    public void setSkor(double skor) {
        this.skor = skor;
    }

    @Override
    public int compareTo(Pokusaj o) {
        if(this.skor > o.skor) return 1;
        else if(this.skor < o.skor) return  -1;
        else return 0;
    }
}
