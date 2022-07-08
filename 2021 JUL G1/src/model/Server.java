package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Server {
    public static Server instance = null;

    private List<Transakcija> sveTransakcije;

    private Set<String> sveKategorije;

    private static int stanjePara;

    private List<Isplata> sveIsplate;


    private Server(){
        sveTransakcije = new ArrayList<>();
        sveIsplate = new ArrayList<>();
        sveKategorije = new HashSet<>();

    }


    public static int racunajStanje(){
        int stanje = 0;
        for (Transakcija transakcija : Server.getInstance().getSveTransakcije()){
            if (transakcija instanceof Uplata) {
                stanje += transakcija.getIznos();
            }else if(transakcija instanceof Isplata)
                stanje -= transakcija.getIznos();
        }
        return stanje;
    }


    public List<Isplata> getSveIsplate() {
        return sveIsplate;
    }




    public static int getStanjePara() {
        return stanjePara;
    }

    public static void setStanjePara(int stanjePara) {
        Server.stanjePara = stanjePara;
    }

    public List<Transakcija> getSveTransakcije() {
        return sveTransakcije;
    }


    public Set<String> getSveKategorije() {
        return sveKategorije;
    }

    public static Server getInstance(){
        if(instance == null)
            instance = new Server();
        return instance;
    }
}
