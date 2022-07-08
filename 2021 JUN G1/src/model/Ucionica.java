package model;

public class Ucionica implements Comparable<Ucionica>{
    private String ime;
    private TipUcionice tip;
    private int kapacitet;


    public Ucionica(String ime, TipUcionice tip) {
        this.ime = ime;
        this.tip = tip;
        if(tip.equals(TipUcionice.obicna) || tip.equals(TipUcionice.R)){
            kapacitet = 15;
        }else if(tip.equals(TipUcionice.A)){
            kapacitet = 30;
        }
    }

    @Override
    public String toString() {
        if(this.tip.equals(TipUcionice.obicna) || this.tip.equals(TipUcionice.A))
            return ime + " - " + kapacitet;
        else
            return ime + "(" + tip + ")" + " - " + kapacitet;
    }

    public String getIme() {
        return ime;
    }

    public TipUcionice getTip() {
        return tip;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    @Override
    public int compareTo(Ucionica o) {
        if(Integer.parseInt(String.valueOf(this.ime.charAt(ime.length()-1))) < Integer.parseInt(String.valueOf(o.ime.charAt(o.ime.length()-1))))
            return 1;
        else return 0;
    }



}
