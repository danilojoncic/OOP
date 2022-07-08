package model;

import javafx.scene.control.ComboBox;

public class Student {
    //RI,3,2018,Martinović,Ivo
    private String ime;
    private String prezime;
    private String smer;
    private int redniBroj;
    private int godUpisa;

    private String imejl;
    private int bod1;
    private int bod2;
    private int bod3;


    public Student(String ime, String prezime, String smer, int redniBroj, int godUpisa) {
        this.ime = ime;
        this.prezime = prezime;
        this.smer = smer;
        this.redniBroj = redniBroj;
        this.godUpisa = godUpisa;
        imejl = praviImejl();

    }

    @Override
    public String toString() {
        return prezime + " " + ime + "," + smer + "-" + godUpisa + "-" + redniBroj;
    }


    public String getImejl() {
        return imejl;
    }

    public int getBod1() {
        return Server.getInstance().vratiBod1(imejl);
    }

    public int getBod2() {
        return Server.getInstance().vratiBod2(imejl);
    }

    public int getBod3() {
        return Server.getInstance().vratiBod3(imejl);
    }

    public String praviImejl(){
        //aalhakan10318ri@raf.rs,1

        String newPrezime = prezime;
        newPrezime = newPrezime.replaceAll("ć", "c");
        newPrezime = newPrezime.replaceAll("č", "c");
        newPrezime = newPrezime.replaceAll("ž", "z");
        newPrezime = newPrezime.replaceAll("đ", "dj");
        newPrezime = newPrezime.replaceAll("š", "s");
        return (ime.charAt(0) + "" + newPrezime + "" + redniBroj + "" + (godUpisa - 2000) +  "" +  smer +   "@raf.rs").toLowerCase();
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
