package view;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Pitanje;
import model.Pokusaj;
import model.Server;
import utils.FileUtil;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainView extends VBox {


    public static ListView<Pitanje> lvPitanja;
    private TableView<Pokusaj> tvPokusaji;
    private ComboBox<String> cmbPredmeti;
    private Button btnUcitaj;
    private Button btnDodaj;
    private Button btnSnimi;
    private Button btnIgraj;

    public MainView() {
        init();
        tabelaInit();
        initHbox();
        initHboxLow();
        actions();
    }

    private void init(){
        lvPitanja = new ListView<>();
        tvPokusaji = new TableView<>();
        cmbPredmeti = new ComboBox<>();
        btnUcitaj = new Button("Ucitaj za predmet");
        btnDodaj = new Button("Dodaj pitanje");
        btnSnimi = new Button("Snimi");
        btnIgraj = new Button("Igraj");
    }

    private void tabelaInit(){
        TableColumn<Pokusaj,String> tcPredmet = new TableColumn<>("Predmet");
        tcPredmet.setCellValueFactory(new PropertyValueFactory<>("predmet"));

        TableColumn<Pokusaj, Date> tcDatum = new TableColumn<>("Datum");
        tcDatum.setCellValueFactory(new PropertyValueFactory<>("datum"));

        TableColumn<Pokusaj,Double> tcSkor = new TableColumn<>("Skor");
        tcSkor.setCellValueFactory(new PropertyValueFactory<>("skor"));

        tvPokusaji.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tvPokusaji.getColumns().addAll(tcPredmet,tcDatum,tcSkor);
        tvPokusaji.getItems().addAll(Server.getInstance().getPokusaji());
    }

    private void initHbox(){
        lvPitanja.getItems().addAll(FXCollections.observableArrayList(Server.getInstance().getPitanja()));
        lvPitanja.setPrefWidth(500);
        lvPitanja.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        HBox hbox = new HBox(10);
        hbox.getChildren().addAll(lvPitanja,tvPokusaji);
        this.getChildren().add(hbox);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(25,25,25,25));
    }

    private void initHboxLow(){
        HBox hbLow = new HBox(10);
        cmbPredmeti.getItems().addAll(Server.getPredmetiZaCmb());
        cmbPredmeti.getItems().add("Svi predmeti");
        cmbPredmeti.setValue("Svi predmeti");
        hbLow.getChildren().addAll(cmbPredmeti,btnUcitaj,btnDodaj,btnSnimi,btnIgraj);
        this.getChildren().add(hbLow);
        hbLow.setAlignment(Pos.CENTER);
        hbLow.setPadding(new Insets(25,25,40,40));
    }

    private void actions(){
        btnIgraj.setOnAction(event -> {
            System.out.println("Igram igram, vrtima se ko cigra");
            PitanjeView.getInstance();
        });


        btnSnimi.setOnAction(event -> {
            System.out.println("Snimam");
            FileUtil.writeFile();
        });

        btnDodaj.setOnAction(event -> {
            System.out.println("Dodajem");
            NapraviiView.getInstance().show();
        });

        btnUcitaj.setOnAction(event -> {
            List<Pitanje> selektovana = new ArrayList<>();
            String izabran = cmbPredmeti.getSelectionModel().getSelectedItem();
            if(izabran.equals("Svi predmeti"))
                selektovana = Server.getInstance().getPitanja();
            else{
            for(Pitanje p: Server.getInstance().getPitanja()) {
                 if (izabran.equals(p.getPredmet()))
                    selektovana.add(p);
                }
            }
            lvPitanja.getItems().clear();
            lvPitanja.getItems().addAll(FXCollections.observableArrayList(selektovana));
        });
    }


}
