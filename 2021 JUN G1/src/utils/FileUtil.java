package utils;

import javafx.scene.control.TableView;
import model.*;

import java.io.*;

public class FileUtil {
    public FileUtil() {
    }
    public static void loadStudents(String fileName){
        //RI,3,2020,Bolović,Aleksa
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null){
                String[] delovi = line.split(",");
                String smer = delovi[0];
                int redniBroj = Integer.parseInt(delovi[1]);
                int godUpisa = Integer.parseInt(delovi[2]);
                String prezime = delovi[3];
                String ime = delovi[4];
                Student s = new Student(ime,prezime,smer,redniBroj,godUpisa);
                Server.getInstance().dodajStudenta(s);
            }
        }catch (Exception ex){
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


    public static void loadClassrooms(String fileName) {
        //RAF7-R
        //RAF8
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null){
                String[] delovi = line.split("-");

                if(delovi.length == 1){
                    Ucionica u = new Ucionica(line, TipUcionice.obicna);
                    Server.getInstance().dodajUcionicu(u);
                }else {
                    Ucionica u = new Ucionica(delovi[0],TipUcionice.valueOf(delovi[1]));
                    Server.getInstance().dodajUcionicu(u);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

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

    public static void writeStuff(String snimljeno, TableView<Termin> tableView){
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter(snimljeno);
            pw = new PrintWriter(fw);
            for(Termin t : tableView.getItems()){
                pw.println(t.getTermin());
                pw.println(t.getStudent() + " " + t.getUcionica());
                pw.println();
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
