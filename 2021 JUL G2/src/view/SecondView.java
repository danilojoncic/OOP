package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Server;

public class SecondView extends Stage {
    public static SecondView instance = null;
    private GridPane gp;
    private TextField tfIme;
    private TextField tfPrezime;
    private TextField tfJMBG;
    private ComboBox<String> cmbPozicija;
    private TextField tfGodineZaposlenja;
    private Button btnDodaj;
    private SecondView(){
        gp = new GridPane();
        init();
        actions();
        setTitle("SecondView");
        gp.setHgap(25);
        gp.setVgap(15);
        gp.setAlignment(Pos.BASELINE_CENTER);
        gp.setPadding(new Insets(15));
        setScene(new Scene(gp,300,275));

    }

    private void init(){
        tfGodineZaposlenja = new TextField();
        tfIme = new TextField();
        tfPrezime = new TextField();
        tfJMBG = new TextField();
        cmbPozicija = new ComboBox<>();
        cmbPozicija.getItems().addAll(Server.getInstance().getCMBsvaZanimanja());
        cmbPozicija.setValue("Direktor");
        btnDodaj = new Button("Dodaj");

        gp.add(new Label("Ime"),0,0);
        gp.add(tfIme,1,0,3,1);
        gp.add(new Label("Prezime"),0,1);
        gp.add(tfPrezime,1,1,3,1);
        gp.add(new Label("JMBG"),0,2);
        gp.add(tfJMBG,1,2,3,1);
        gp.add(new Label("Pozicija"),0,3);
        gp.add(cmbPozicija,1,3);
        gp.add(new Label("Godina zaposlenja"),0,4);
        gp.add(tfGodineZaposlenja,1,4,3,1);
        gp.add(btnDodaj,0,5);
    }

    private void actions(){
        btnDodaj.setOnAction(event -> {
            System.out.println("Dodao sam kes kolica");
        });
    }


    public static SecondView getInstance(){
        if (instance == null)
            instance = new SecondView();
        return instance;
    }


    public GridPane getGp() {
        return gp;
    }

    public TextField getTfIme() {
        return tfIme;
    }

    public TextField getTfPrezime() {
        return tfPrezime;
    }

    public TextField getTfJMBG() {
        return tfJMBG;
    }

    public ComboBox<String> getCmbPozicija() {
        return cmbPozicija;
    }

    public TextField getTfGodineZaposlenja() {
        return tfGodineZaposlenja;
    }

    public Button getBtnDodaj() {
        return btnDodaj;
    }
}
