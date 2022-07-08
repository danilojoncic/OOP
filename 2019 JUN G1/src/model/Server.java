package model;

import java.util.*;

public class Server {
    public static Server instance = null;
    private List<String> sviMejlovi;

    private Map<String,Integer> pitanje1;
    private Map<String,Integer> pitanje2;
    private Map<String,Integer> pitanje3;
    List<Student> sviStudenti;
    private Server(){
        sviStudenti = new ArrayList<>();
        sviMejlovi = new ArrayList<>();
        pitanje1 = new HashMap<>();
        pitanje2 = new HashMap<>();
        pitanje3 = new HashMap<>();
    }



    public int vratiBod1(String mejl){
        int bod1 = 0;
        for (String string : Server.getInstance().pitanje1.keySet()){
            if (mejl.equalsIgnoreCase(string)) {
                bod1 = pitanje1.get(mejl);

                break;
            }
        }
        return bod1;
    }



    public int vratiBod2(String mejl){
        int bod2 = 0;
        for (String string : Server.getInstance().pitanje2.keySet()){
            if (mejl.equalsIgnoreCase(string)) {
                bod2 = pitanje2.get(mejl);
                System.out.println(mejl + " " + string);
                System.out.println(bod2);
                break;
            }
        }
        return bod2;
    }

    public int vratiBod3(String mejl){
        int bod3 = 0;
        for (String string : Server.getInstance().pitanje3.keySet()){
            if (mejl.equalsIgnoreCase(string)) {
                bod3 = pitanje1.get(mejl);
                System.out.println(mejl + " " + string);
                System.out.println(bod3);
                break;
            }
        }
        return bod3;
    }


    public List<String> getSviMejlovi() {
        return sviMejlovi;
    }

    public Map<String, Integer> getPitanje1() {
        return pitanje1;
    }

    public Map<String, Integer> getPitanje2() {
        return pitanje2;
    }

    public Map<String, Integer> getPitanje3() {
        return pitanje3;
    }

    public List<Student> getSviStudenti() {
        return sviStudenti;
    }
    public static Server getInstance(){
        if (instance == null)
            instance = new Server();
        return instance;
    }
}
