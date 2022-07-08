package model;

public class Student {

    private String ime;
    private String prezime;
    private String smer;
    private int redniBroj;
    private int godUpisa;


    public Student(String ime, String prezime, String smer, int redniBroj, int godUpisa) {
        this.ime = ime;
        this.prezime = prezime;
        this.smer = smer;
        this.redniBroj = redniBroj;
        this.godUpisa = godUpisa;
    }

    @Override
    public String toString() {
        return ime + " " + prezime + " " + redniBroj + "/" + smer + "-" + godUpisa;
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

    public int getRedniBroj() {
        return redniBroj;
    }

    public int getGodUpisa() {
        return godUpisa;
    }
}
