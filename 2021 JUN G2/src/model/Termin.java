package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Termin {
    private String ucionica;
    private int vreme;
    private List<Student> studenti;
    private Ucionica ucionica1;

    public Termin(String ucionica, int vreme) {
        this.ucionica = ucionica;
        this.vreme = vreme;
        studenti = new ArrayList<>();
        this.ucionica1 = new Ucionica(ucionica,12);
    }

    public  int getBrojStudenata(){
        return studenti.size();
    }

    public int getPrekoracenje(){
        if(studenti.size() > ucionica1.getKapacitet())
            return studenti.size() - ucionica1.getKapacitet();
        else return 0;
    }

    public int getSlobodno(){
        if (getPrekoracenje() >= 0) return 0;
        else return ucionica1.getKapacitet() - studenti.size();

    }

    public List<Student> getStudenti() {
        return studenti;
    }

    public String getUcionica() {
        return ucionica;
    }

    public int getVreme() {
        return vreme;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Termin termin = (Termin) o;
        return vreme == termin.vreme && Objects.equals(ucionica, termin.ucionica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ucionica, vreme, studenti);
    }


}
