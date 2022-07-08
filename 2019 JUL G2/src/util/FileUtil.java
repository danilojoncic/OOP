package util;

import model.Server;
import model.Termin;
import model.Ucionica;

import java.io.*;

public class FileUtil {
    public FileUtil() {
    }


    public static void readFile(String fileName){
        //Diskretne strukture,Predavanja,Jovanovic Irena,101 102,PET,09:15-11,U6
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null){
                String[] delovi = line.split(",");
                String predmet = delovi[0];
                String tip = delovi[1];
                String profesor = delovi[2];
                String grupe = delovi[3];
                String dan = delovi[4];
                String odDo = delovi[5];
                String[] podDelovi = odDo.split("-");
                String pocetak = podDelovi[0];
                String kraj = podDelovi[1];
                String ucionica = delovi[6];
                Server.getInstance().getSviDani().add(dan);
                Ucionica ucionica1 = new Ucionica(predmet,tip,profesor,grupe,dan,pocetak,kraj,ucionica);
                Server.getInstance().getSveUcionice().add(ucionica1);
            }
        }catch (Exception exception){
            exception.printStackTrace();
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

    public static void writeStuff(String fileName){
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter(fileName);
            pw = new PrintWriter(fw);
            for (Termin termin : Server.getInstance().getSviTermini()){
                pw.println(termin);
            }
        }catch (Exception exception){
            exception.printStackTrace();
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
