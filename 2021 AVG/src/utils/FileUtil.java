package utils;

import model.Pitanje;
import model.Server;
import view.MainView;

import java.io.*;
import java.util.Locale;

public class FileUtil {
    public FileUtil() {
    }


    public static void loadFile(String fileName){
        //Da li se u konstruktoru može koristiti rezervisana reč this?;Da;OOP     split sa ;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null){
                String[] delovi = line.split(";");
                String tekst = delovi[0];
                String odgovor = delovi[1];
                String predmet = delovi[2];
                Pitanje p = new Pitanje(tekst,odgovor,predmet);
                Server.dodajPitanje(p);
                Server.dodajPredemt(predmet);
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



    public static void writeFile(){
        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            File fajl = new File("Snimljeno.txt");
            fw = new FileWriter(fajl);
            pw = new PrintWriter(fw);

            for(Pitanje p : MainView.lvPitanja.getSelectionModel().getSelectedItems()){
                pw.println(p);
            }



        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            pw.close();
            try {
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }



}
