package util;

import model.Server;
import model.Student;
import view.MainView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {
    public FileUtil() {
    }

    public static void ucitajStudenta(String fileName) {

        //RI,6,2018,Bogićević,Marko
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] delovi = line.split(",");
                String ime = delovi[4];
                String prezime = delovi[3];
                String smer = delovi[0];
                int redniBroj = Integer.parseInt(delovi[1]);
                int godUpisa = Integer.parseInt(delovi[2]);
                Student student = new Student(ime, prezime, smer, redniBroj, godUpisa);
                Server.getInstance().getSviStudenti().add(student);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
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


    public static void ucitajPitanje1(String fileName) {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String line = "";
            //aalhakan17@raf.rs,1
            while ((line = br.readLine()) != null) {
                String[] delovi = line.split(",");
                String mejl = delovi[0];
                int bod1 = Integer.parseInt(delovi[1]);
                Server.getInstance().getPitanje1().put(mejl, bod1);
                Server.getInstance().getSviMejlovi().add(mejl);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
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


    public static void ucitajPitanje2(String fileName){
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String line5 = "";
            while ((line5 = br.readLine()) != null){
                String dijelovi[] = line5.split(",");
                String email = dijelovi[0];
                int bodovi = Integer.parseInt(dijelovi[1]);
                Server.getInstance().getPitanje2().put(email,bodovi);

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


    public static void ucitajPitanje3(String fileName){
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String linija = "";
            while ((linija = br.readLine()) != null){
                String parts[] = linija.split(",");
                String adresa = parts[0];
                int points = Integer.parseInt(parts[1]);
                Server.getInstance().getPitanje3().put(adresa,points);
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
}



