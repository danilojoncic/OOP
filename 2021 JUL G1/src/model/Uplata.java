package model;

import java.util.Date;

public class Uplata extends Transakcija{


    public Uplata(int iznos, String primalac, String datum, String tip) {
        super(iznos, primalac, datum,tip);
        tip = "UPLATA";
    }





}
