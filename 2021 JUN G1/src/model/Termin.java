package model;

public class Termin {
    private Student student;
    private String termin;
    private Ucionica ucionica;


    public Termin(Student student, String termin, Ucionica ucionica) {
        this.student = student;
        this.termin = termin;
        this.ucionica = ucionica;
    }


    public Student getStudent() {
        return student;
    }

    public String getTermin() {
        return termin;
    }

    public Ucionica getUcionica() {
        return ucionica;
    }
}
