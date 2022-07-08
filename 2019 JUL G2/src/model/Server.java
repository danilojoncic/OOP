package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Server {

    public static Server instance = null;
    private List<Ucionica> sveUcionice;
    private Set<String> sviDani;
    private List<Termin> sviTermini;
    private Server(){
        sveUcionice = new ArrayList<>();
        sviDani = new HashSet<>();
        sviTermini = new ArrayList<>();
    }

    public List<Termin> getSviTermini() {
        return sviTermini;
    }

    public List<Ucionica> getSveUcionice() {
        return sveUcionice;
    }

    public Set<String> getSviDani() {
        return sviDani;
    }

    public static Server getInstance(){
        if (instance == null)
            instance = new Server();
        return instance;
    }


}
