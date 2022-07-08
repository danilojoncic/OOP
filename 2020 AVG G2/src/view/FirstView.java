package view;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Knjiga;
import model.Server;

import java.util.List;


public class FirstView extends VBox {


    private ComboBox<Knjiga> cmbPredmet;
    private Button btnFilter;
    private Button btnPregled;
    private TableView<Knjiga> tvKnjiga;
    private Button btnIzaberi;
    private ListView<Knjiga> lvKnjiga;
    private Button btnSacuvaj;

    public FirstView() {
        initElement1();
        initTable();
        initList();
        initActions();
    }

    private void initElement1(){
        HBox hBoxBig = new HBox();
        VBox vBoxInner = new VBox();
        btnPregled = new Button("Pregled po autorima");
        btnFilter = new Button("Filtriraj");
        cmbPredmet = new ComboBox<>();
        cmbPredmet.getItems().addAll(Server.getInstance().getKnjigeCMB());


        vBoxInner.getChildren().addAll(cmbPredmet,btnFilter);
        vBoxInner.setSpacing(10);
        vBoxInner.setPadding(new Insets(10));

        hBoxBig.getChildren().addAll(vBoxInner,btnPregled);
        this.getChildren().addAll(hBoxBig);
        hBoxBig.setAlignment(Pos.CENTER);
        hBoxBig.setSpacing(10);
        hBoxBig.setPadding(new Insets(10));
    }

    private void initTable(){
        tvKnjiga = new TableView<>();

        TableColumn<Knjiga,Integer> tcRazred = new TableColumn<>("Razred");
        tcRazred.setCellValueFactory(new PropertyValueFactory<>("razred"));

        TableColumn<Knjiga,String> tcIzdavasc = new TableColumn<>("Izdavac");
        tcIzdavasc.setCellValueFactory(new PropertyValueFactory<>("izdavac"));

        TableColumn<Knjiga,String> tcPredmet = new TableColumn<>("Predmet");
        tcPredmet.setCellValueFactory(new PropertyValueFactory<>("predmet"));

        TableColumn<Knjiga, String> tcNaslov = new TableColumn<>("Naslov");
        tcNaslov.setCellValueFactory(new PropertyValueFactory<>("naslov"));

        TableColumn<Knjiga, List<String>> tcAutori = new TableColumn<>("Autori");
        tcAutori.setCellValueFactory(new PropertyValueFactory<>("autori"));

        tvKnjiga.getColumns().addAll(tcRazred,tcIzdavasc,tcPredmet,tcNaslov,tcAutori);
        this.getChildren().addAll(tvKnjiga);
        tvKnjiga.setPrefHeight(250);
        tvKnjiga.getItems().addAll(FXCollections.observableArrayList(Server.getInstance().getKnjige()));


        HBox hboxMid = new HBox(10);
        btnIzaberi = new Button("Izaberi");
        hboxMid.getChildren().add(btnIzaberi);
        hboxMid.setAlignment(Pos.CENTER);
        hboxMid.setSpacing(10);
        hboxMid.setPadding(new Insets(10));
        this.getChildren().add(hboxMid);

    }

    private void initList(){
        lvKnjiga = new ListView<>();
        lvKnjiga.setPrefHeight(100);
        this.getChildren().add(lvKnjiga);

        HBox hBoxLow = new HBox(10);
        btnSacuvaj = new Button("Sacuvaj");
        hBoxLow.getChildren().add(btnSacuvaj);
        this.getChildren().add(hBoxLow);
        hBoxLow.setAlignment(Pos.CENTER);
        hBoxLow.setPadding(new Insets(10));


    }

    private void initActions(){
        btnSacuvaj.setOnAction(event -> {
            System.out.println("Sacuvao sam WIP");
        });
        btnIzaberi.setOnAction(event -> {
            System.out.println("Izabrao sam WIP");
        });
        btnFilter.setOnAction(event -> {
            System.out.println("FIltrirao sam WIP");
        });

        btnPregled.setOnAction(event -> {
            System.out.println("Pregledao sam po autorima WIP");

        });
    }

}
