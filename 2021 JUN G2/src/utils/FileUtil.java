package utils;

import model.Server;
import model.Student;
import model.Termin;
import model.Ucionica;

import java.io.*;

public class FileUtil {
    public FileUtil() {
    }

    //RI,3,2020,Bolović,Aleksa,12,RAF6


    public static void ucitajTermin(String fileName){
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] delovi = line.split(",");
                String smer = delovi[0];
                String ime = delovi[4];
                String prezime = delovi[3];
                int godUpisa = Integer.parseInt(delovi[2]);
                int redniBroj = Integer.parseInt(delovi[1]);
                int vreme = Integer.parseInt(delovi[5]);
                String ucionica = delovi[6];

                Student student = new Student(ime, prezime, smer, godUpisa, redniBroj, ucionica, vreme);
                Termin t = new Termin(ucionica, vreme);
                Server.getInstance().getSviTermini().add(t);
                Server.getInstance().getSviStudenti().add(student);
                Server.getInstance().getSvoVreme().add(vreme);
                if(student.getUcionica().equals(t.getUcionica()) && student.getVreme() == t.getVreme())
                    t.getStudenti().add(student);
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










    public static void ucitajUcionicu(String fileName){
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null){
                String []delovi = line.split("-");
                Ucionica u = new Ucionica(delovi[0],Integer.parseInt(delovi[1]));
                Server.getInstance().getSveUcionice().add(u);
                Server.getInstance().getSviNaziviUcionica().add(u.getNaziv());
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
            for (Student student : Server.getInstance().getSviStudenti()){
                pw.println(student.getUcionica() + " " + student.getVreme());
                for(Student student1 : Server.getInstance().getSviStudenti()) {
                    if(student1.getUcionica().equals(student.getUcionica()) && student1.getVreme() == student.getVreme())
                        pw.println(student1);
                }
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
