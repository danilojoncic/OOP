package utill;

import model.Isplata;
import model.Server;
import model.Transakcija;
import model.Uplata;

import java.io.*;
import java.util.Date;

public class FileUtil
{
    public FileUtil() {
    }


    public static void ucitajFajl(String fileName){
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            //5000;Osiguravajuca kuca "Bolji zivot";15.04.2021.;OSIGURANJE
            //3000;Vlada RS;16.04.2021.
            String line = "";
            while((line = br.readLine()) != null) {
                String[] delovi = line.split(";");
                int iznos = Integer.parseInt(delovi[0]);
                String primalac = delovi[1];
                String datum = delovi[2];
                Transakcija transakcija;
                if (delovi.length == 4){
                    transakcija = new Isplata(iznos, primalac, datum, "ISPLATA", delovi[3]);
                    Server.getInstance().getSveTransakcije().add(transakcija);
                    Server.getInstance().getSveKategorije().add(delovi[3]);
                    Server.getInstance().getSveIsplate().add((Isplata) transakcija);
                }else if (delovi.length < 4) {
                    transakcija = new Uplata(iznos, primalac, datum, "UPLATA");
                    Server.getInstance().getSveTransakcije().add(transakcija);
                }
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

    public static void pisiFajl(String fileName){
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter(fileName);
            pw = new PrintWriter(fw);
            for (Transakcija transakcija: Server.getInstance().getSveTransakcije()) {
                pw.println(transakcija.getTip());
                pw.println(transakcija.getIznos() + " " +  transakcija.getPrimalac() + " " + transakcija.getTip() );
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
