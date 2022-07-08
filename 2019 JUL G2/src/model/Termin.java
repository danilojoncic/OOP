package model;

import java.util.Objects;

public class Termin {
    private String ucionicaTermina;
    private String zauzetiTermin;
    private String grupeTermina;

    public Termin(String ucionicaTermina, String zauzetiTermin, String grupeTermina) {
        this.ucionicaTermina = ucionicaTermina;
        this.zauzetiTermin = zauzetiTermin;
        this.grupeTermina = grupeTermina;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Termin termin = (Termin) o;
        return Objects.equals(ucionicaTermina, termin.ucionicaTermina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ucionicaTermina);
    }

    public String getUcionicaTermina() {
        return ucionicaTermina;
    }

    public String getZauzetiTermin() {
        return zauzetiTermin;
    }

    public String getGrupeTermina() {
        return grupeTermina;
    }


    @Override
    public String toString() {
        return "[" + zauzetiTermin + "] " +  "["   + grupeTermina +  "]  @" + ucionicaTermina;
    }
}
