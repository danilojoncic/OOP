package util;

import model.Server;
import model.Zanimanje;
import model.Zaposlen;

import java.io.*;

public class FileUtil {
    public FileUtil() {
    }


    public static void ucitajZanimanje(String fileName){
        FileReader fr = null;
        BufferedReader br = null;
        try {
            //Mesar,1.875
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null){
                String[] delovi = line.split(",");
                String naziv = delovi[0];
                double koeficijent = Double.parseDouble(delovi[1]);
                Zanimanje zanimanje = new Zanimanje(naziv,koeficijent);
                Server.getInstance().getCMBsvaZanimanja().add(naziv);
                Server.getInstance().getSvaZanimanja().add(zanimanje);
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



    public static void ucitajZaposlenog(String fileName){
        FileReader fr = null;
        BufferedReader br = null;
        //Mesar
        //Neđo,Čavić,0317886784497,2019
        //Dragan,Čurlić,3932877756267,2015
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String line = "";
            String zanimanje = "";
            while ((line = br.readLine()) != null){
                String[] delovi = line.split(",");
                if (delovi.length == 1){
                    zanimanje = delovi[0];
                }else if (delovi.length == 4){
                    String ime = delovi[0];
                    String prezime = delovi[1];
                    long JMBG = Long.parseLong(delovi[2]);
                    int godinaZaposlenja = Integer.parseInt(delovi[3]);
                    Zaposlen zaposlen = new Zaposlen(ime,prezime,JMBG,Server.getInstance().nadjiZanimanje(zanimanje));
                    Server.getInstance().getSviZaposleni().add(zaposlen);
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

    public static void ispisiFajl(String fileName){
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter(fileName);
            pw = new PrintWriter(fw);
            for(Zanimanje zanimanje : Server.instance.getSvaZanimanja()) {
                pw.println(zanimanje.getNaziv());
                for(Zaposlen zaposlen : Server.getInstance().getSviZaposleni())
                    if (zanimanje.getNaziv().equals(zaposlen.getPozicija()))
                        pw.println(zaposlen);
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
