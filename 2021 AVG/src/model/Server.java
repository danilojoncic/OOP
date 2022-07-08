package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Server {
    public static Server instance = null;
    private static List<Pitanje> pitanja;
    private static List<Pokusaj> pokusaji;
    private static Set<String> predmetiZaCmb;




    private Server(){
        pitanja = new ArrayList<>();
        pokusaji = new ArrayList<>();
        predmetiZaCmb = new HashSet<>();
    }

    public static Server getInstance(){
        if(instance == null)
            instance = new Server();
        return instance;
    }

    public static void dodajPredemt(String predmet){
        predmetiZaCmb.add(predmet);
    }

    public static Set<String> getPredmetiZaCmb() {
        return predmetiZaCmb;
    }

    public List<Pitanje> getPitanja() {
        return pitanja;
    }

    public List<Pokusaj> getPokusaji() {
        return pokusaji;
    }


    public static void dodajPitanje(Pitanje p){
        pitanja.add(p);
    }

    public static void dodajPokusaj(Pokusaj pok){
        pokusaji.add(pok);
    }



}
