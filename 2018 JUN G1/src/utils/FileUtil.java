package utils;

import model.Mec;
import model.Server;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileUtil {


    public FileUtil() {
    }

    public static void ucitajFajl(String filename) {

        FileReader fr = null;
        BufferedReader br = null;
        //Rusija-Saudijska Arabija,5:0
        try {
             fr = new FileReader(filename);
             br = new BufferedReader(fr);

             String linija = null;
             String grupa = "";

            while((linija = br.readLine()) != null){
                if(linija.length() == 1){

                    grupa = linija;
                    //System.out.println(grupa);

                    //System.out.println(linija);
                }else {


                    String[] red = linija.split(",");
                    //System.out.println(red);
                    //System.out.println(linija);
                    System.out.println(red[1]);
                    String mec = red[0];
                    //System.out.println(mec);

                    String[] timovi = mec.split("-");

                    String tim1 = timovi[0];
                    //System.out.println(tim1);

                    String tim2 = timovi[1];
                    //System.out.println(tim2);

                    String[] rezultat = red[1].split(":");
                    //System.out.println(rezultat);

                    int gol1 = Integer.parseInt(rezultat[0]);

                    int gol2 = Integer.parseInt(rezultat[1]);

                    Mec mec1 = new Mec(tim1,tim2,gol1,gol2,grupa);
                    //System.out.println(mec1);



                    Server.getInstance().dodajMec(mec1);
                    Server.getInstance().dodajGrupu(grupa);
                    //Server.SERVER.sviMecevi.add(mec1);
                    //Server.SERVER.grupe.add(grupa);
                    //System.out.println(mec1.getGrupa());
                    //Server.SERVER.dodajMec(mec1);
                    //System.out.println(Server.SERVER.sviMecevi);
                    //Server.SERVER.dodajGrupu(grupa);
                    //System.out.println(Server.SERVER.grupe);
                }



            }





        }catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
