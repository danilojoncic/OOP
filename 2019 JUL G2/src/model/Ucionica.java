package model;

public class Ucionica {

    //Diskretne strukture,Predavanja,Jovanovic Irena,101 102,PET,09:15-11,U6
    private String predmet;
    private String tip;
    private String profesor;
    private String grupe;
    private String dan;
    private String pocetak;
    private String kraj;
    private String ucionica;


    public Ucionica(String predmet, String tip, String profesor, String grupe,
                    String dan, String pocetak, String kraj, String ucionica) {
        this.predmet = predmet;
        this.tip = tip;
        this.profesor = profesor;
        this.grupe = grupe;
        this.dan = dan;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.ucionica = ucionica;
    }


    public String getPredmet() {
        return predmet;
    }

    public String getTip() {
        return tip;
    }

    public String getProfesor() {
        return profesor;
    }

    public String getGrupe() {
        return grupe;
    }

    public String getDan() {
        return dan;
    }

    public String getPocetak() {
        return pocetak;
    }

    public String getKraj() {
        return kraj;
    }

    public String getUcionica() {
        return ucionica;
    }
}
