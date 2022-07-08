package model;

import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Server {

    public static Server instance = null;
    public static int cenaRada;
    private Set<String> CMBsvaZanimanja;
    private List<Zanimanje> svaZanimanja;
    private List<Zaposlen> sviZaposleni;
    private Server(){
        cenaRada = 0;
        CMBsvaZanimanja = new HashSet<>();
        svaZanimanja = new ArrayList<>();
        sviZaposleni = new ArrayList<>();
    }
    public static Server getInstance(){
        if (instance == null)
            instance = new Server();
        return instance;
    }


    public Zanimanje nadjiZanimanje(String naziv){
        for (Zanimanje zanimanje : this.getSvaZanimanja()){
            if (zanimanje.getNaziv().equals(naziv))
                return zanimanje;
        }
        return null;
    }


    public List<Zaposlen> getSviZaposleni() {
        return sviZaposleni;
    }

    public Set<String> getCMBsvaZanimanja() {
        return CMBsvaZanimanja;
    }

    public List<Zanimanje> getSvaZanimanja() {
        return svaZanimanja;
    }

    public static void setCenaRada(int cenaRada) {
        Server.cenaRada = cenaRada;
    }

    public static int getCenaRada(TextField textField) {
        cenaRada = Integer.parseInt(textField.getText());


        return cenaRada;
    }
}
