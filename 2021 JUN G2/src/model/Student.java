package model;

import java.util.Objects;

public class Student {
    private String ime;
    private String prezime;
    private String smer;
    private int godUpisa;
    private int redniBroj;
    private String ucionica;
    private int vreme;


    public Student(String ime, String prezime, String smer, int godUpisa, int redniBroj, String ucionica, int vreme) {
        this.ime = ime;
        this.prezime = prezime;
        this.smer = smer;
        this.godUpisa = godUpisa;
        this.redniBroj = redniBroj;
        this.ucionica = ucionica;
        this.vreme = vreme;
    }

    @Override
    public String toString() {
        return ime + " " + prezime + " " + redniBroj + "/" + smer + "-" + godUpisa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return godUpisa == student.godUpisa && redniBroj == student.redniBroj && Objects.equals(ime, student.ime) && Objects.equals(prezime, student.prezime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ime, prezime, godUpisa, redniBroj);
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getSmer() {
        return smer;
    }

    public int getGodUpisa() {
        return godUpisa;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public String getUcionica() {
        return ucionica;
    }

    public int getVreme() {
        return vreme;
    }
}
