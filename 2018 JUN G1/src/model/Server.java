package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Server {




    public static Server instance;

    public List<Mec> sviMecevi = null;
    public Set<String> grupe = null;


    private Server(){
        sviMecevi = new ArrayList<>();
        grupe = new HashSet<>();
        System.out.println(sviMecevi);
        System.out.println(grupe);
    }

    public static Server getInstance(){
        if(instance == null)
            instance = new Server();
        return instance;
    }


    public void dodajGrupu(String grupa){
        grupe.add(grupa);
    }


    public void dodajMec( Mec mec){
        sviMecevi.add(mec);
    }

    public List<Mec> getSviMecevi() {
        return sviMecevi;
    }

    public void setSviMecevi(List<Mec> sviMecevi) {
        this.sviMecevi = sviMecevi;
    }

    public Set<String> getGrupe() {
        return grupe;
    }

    public void setGrupe(Set<String> grupe) {
        this.grupe = grupe;
    }
}
