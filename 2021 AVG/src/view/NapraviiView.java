package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.border.Border;

public class NapraviiView extends Stage {
    //Singleton
    public static NapraviiView instance;
    private static VBox vboxGlavni;
    private Button btnOdustani;
    private Button btnNapravi;
    private TextField tfPitanje;
    private TextField tfPredmet;
    private TextField tfOdgovor;
    private HBox hBoxPitanje;
    private HBox hBoxPredmet;
    private HBox hBoxOdgovor;
    private HBox HBoxPitanja1;
    private NapraviiView(){
        init();
        sastavi();
        setTitle("Napravi pitanje i dodaj ga u listu");
        setScene(new Scene(vboxGlavni,350,200));

    }


    private void init(){
        vboxGlavni = new VBox(25);
        btnOdustani = new Button("Odustani");
        btnOdustani.setOnAction(event -> {
            this.close();
        });
        btnNapravi = new Button("Dodaj");
        Label lblPitanje = new Label("Pitanje");
        tfOdgovor = new TextField();
        tfPitanje = new TextField();
        tfPredmet = new TextField();
        hBoxPredmet = new HBox();
        hBoxPitanje = new HBox();
        hBoxOdgovor = new HBox();
        HBoxPitanja1 = new HBox();

    }


    private void sastavi(){

        hBoxPitanje.getChildren().addAll(new Label("Pitanje"), tfPitanje);
        hBoxPitanje.setAlignment(Pos.CENTER);
        hBoxPitanje.setSpacing(25);

        hBoxPredmet.getChildren().addAll(new Label("Predmet"),tfPredmet);
        hBoxPredmet.setAlignment(Pos.CENTER);
        hBoxPredmet.setSpacing(25);

        hBoxOdgovor.getChildren().addAll(new Label("Odgovor"),tfOdgovor);
        hBoxOdgovor.setAlignment(Pos.CENTER);
        hBoxOdgovor.setSpacing(25);

        HBoxPitanja1.getChildren().addAll(btnOdustani,btnNapravi);
        HBoxPitanja1.setSpacing(200);

        vboxGlavni.getChildren().addAll(hBoxPitanje,hBoxPredmet,hBoxOdgovor,HBoxPitanja1);
        vboxGlavni.setPadding(new Insets(15));
    }




    public static NapraviiView getInstance(){
        if(instance == null)
            instance = new NapraviiView();
        return instance;
    }
}
