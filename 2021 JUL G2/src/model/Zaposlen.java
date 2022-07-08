package model;

import view.FirstView;

public class Zaposlen {
    private String ime;
    private String prezime;
    private long JMBG;
    private String pozicija;
    private double plata;
    private int godinaZaposlenja;
    private Zanimanje zanimanje;


    public Zaposlen(String ime, String prezime, long JMBG, Zanimanje zanimanje) {
        this.ime = ime;
        this.prezime = prezime;
        this.JMBG = JMBG;
        this.zanimanje = zanimanje;
    }



    @Override
    public String toString() {
        return ime + "," + prezime + "," + JMBG + "," + godinaZaposlenja;
    }


    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public long getJMBG() {
        return JMBG;
    }



    public String getPozicija() {
        return pozicija;
    }

    public double getPlata() {
        return plata;


    }

    public int getGodinaZaposlenja() {
        return godinaZaposlenja;
    }

    public Zanimanje getZanimanje() {
        return zanimanje;
    }
}
