package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Server {
    //singleton

    public static Server instance = null;
    private List<Student> sviStudenti;
    private Set<Ucionica> sveUcionice;

    private Set<Termin> termini;
    private Server(){
        sviStudenti = new ArrayList<>();
        sveUcionice = new HashSet<>();
        termini = new HashSet<>();
    }


    public void dodajTermin(Termin t){
        termini.add(t);
    }

    public void dodajUcionicu(Ucionica u){
        sveUcionice.add(u);
    }

    public void dodajStudenta(Student s){
        sviStudenti.add(s);
    }


    public static Server getInstance(){
        if(instance == null)
            instance = new Server();
        return instance;
    }

    public List<Student> getSviStudenti() {
        return sviStudenti;
    }

    public Set<Ucionica> getSveUcionice() {
        return sveUcionice;
    }

    public Set<Termin> getTermini() {
        return termini;
    }
}
