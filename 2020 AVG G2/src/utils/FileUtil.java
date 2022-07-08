package utils;

import model.Knjiga;
import model.Server;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FileUtil {

    public static void ucitajFajl(String filename){
            //EDUKA
        //Čitanka,[Ivan Jović, Monja Jović],3. razred,SRPSKI JEZIK

        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(filename);
            br = new BufferedReader(fr);
            String line = null;
            String izdavac = null;
            while ((line = br.readLine()) != null){
                String []a = line.split(",");
                if(a.length == 1){
                    izdavac = line;
                }else if(a.length >= 4){
                    String naslov = a[0];
                    int n = a.length;
                    StringBuilder sb = new StringBuilder();
                    for(int i = 1; i < n- 2; ++i)
                        sb.append(a[i]);
                    String autori = sb.toString();

                    int razred = Integer.parseInt(String.valueOf(a[n-2].charAt(0)));
                    String predmet = a[n-1];
                    Knjiga k = new Knjiga(razred,izdavac,predmet,naslov,autori);
                    Server.getInstance().dodajKnjigu(k);
                    Server.getInstance().dodajCMB(k);


                }else break;





            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }






    }



}
