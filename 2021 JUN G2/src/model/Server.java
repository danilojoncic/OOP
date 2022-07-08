package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Server {
    public static Server instance = null;

    private List<Ucionica> sveUcionice;
    private List<Termin> sviTermini;
    private Set<Integer> svoVreme;
    private Set<String> sviNaziviUcionica;
    private List<Student> sviStudenti;
    private Server(){
        sviTermini = new ArrayList<>();
        sveUcionice = new ArrayList<>();
        sviNaziviUcionica = new HashSet<>();
        svoVreme = new HashSet<>();
        sviStudenti = new ArrayList<>();
    }

    public List<Student> getSviStudenti() {
        return sviStudenti;
    }

    public List<Termin> getSviTermini() {
        return sviTermini;
    }

    public Set<Integer> getSvoVreme() {
        return svoVreme;
    }

    public Set<String> getSviNaziviUcionica() {
        return sviNaziviUcionica;
    }

    public List<Ucionica> getSveUcionice() {
        return sveUcionice;
    }

    public static Server getInstance(){
        if(instance == null)
            instance = new Server();
        return instance;
    }
}
