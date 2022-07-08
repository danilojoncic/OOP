package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Server {


    private List<Knjiga> knjige;
    private Set<String[]> sviAutori;
    private Set<Knjiga> knjigeCMB;
    public static Server instance = null;
    private Server(){
        knjige = new ArrayList<>();
        sviAutori = new HashSet<String[]>();
        knjigeCMB = new HashSet<>();
    }

    public void dodajKnjigu(Knjiga k){
        knjige.add(k);
    }

    public void dodajAutora(String[] s){
        sviAutori.add(s);
    }

    public void dodajCMB(Knjiga k){
        knjigeCMB.add(k);
    }

    public List<Knjiga> getKnjige() {
        return knjige;
    }

    public void setKnjige(List<Knjiga> knjige) {
        this.knjige = knjige;
    }

    public Set<String[]> getSviAutori() {
        return sviAutori;
    }

    public void setSviAutori(Set<String[]> sviAutori) {
        this.sviAutori = sviAutori;
    }

    public Set<Knjiga> getKnjigeCMB() {
        return knjigeCMB;
    }

    public void setKnjigeCMB(Set<Knjiga> knjigeCMB) {
        this.knjigeCMB = knjigeCMB;
    }

    public static Server getInstance(){
        if(instance == null)
            instance = new Server();
        return instance;
    }
}
