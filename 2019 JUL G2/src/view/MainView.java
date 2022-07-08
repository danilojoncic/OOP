package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Server;
import model.Termin;
import model.Ucionica;
import util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class MainView extends Stage {
    public static MainView instance = null;
    private VBox vBoxGlavni;
    private HBox hBoxTop;
    private ComboBox<String> cmbDani;
    private TextField tfOd;
    private TextField tfdDo;
    private Button btnFIltriraj;
    private Button btnPrikazi;
    private TableView<Ucionica> tvUcionica;
    private HBox hBoxObracun;
    private Button btnObracunaj;
    private TableView<Termin> tvTermini;
    private HBox hBoxSacuvaj;
    private Button btnSacuvaj;
    private MainView(){
        vBoxGlavni = new VBox();
        setTitle("OOP 2019 JUL G2");
        initHboxTop();
        initTable1();
        initHBoxMid();
        initTable2();
        initHboxLow();
        sastavi();
        actions();
        setScene(new Scene(vBoxGlavni,800,600));

    }
    private void initHboxTop(){
        hBoxTop = new HBox();
        cmbDani = new ComboBox<>();
        cmbDani.getItems().addAll(FXCollections.observableSet(Server.getInstance().getSviDani()));
        cmbDani.setValue("SRE");
        tfdDo = new TextField();
        tfOd = new TextField();
        btnFIltriraj = new Button("Filtriraj");
        btnPrikazi = new Button("Prikazi sve");
        hBoxTop.getChildren().addAll(new Label("Dan"),cmbDani,
                new Label("Iskljuci termine od:"),tfOd,new Label("do:"), tfdDo,btnFIltriraj,btnPrikazi);
        hBoxTop.setAlignment(Pos.BASELINE_CENTER);
        hBoxTop.setSpacing(10);
    }
    private void initTable1(){
        tvUcionica = new TableView<>();
        TableColumn<Ucionica,String> tcPredmet = new TableColumn<>("Predmet");
        tcPredmet.setCellValueFactory(new PropertyValueFactory<>("predmet"));

        TableColumn<Ucionica,String> tcNastavnik = new TableColumn<>("Nastavnik");
        tcNastavnik.setCellValueFactory(new PropertyValueFactory<>("profesor"));

        TableColumn<Ucionica,String> tcVrsta = new TableColumn<>("Vrsta");
        tcVrsta.setCellValueFactory(new PropertyValueFactory<>("tip"));

        TableColumn<Ucionica,String> tcDan = new TableColumn<>("Dan");
        tcDan.setCellValueFactory(new PropertyValueFactory<>("dan"));

        TableColumn<Ucionica,String> tcUcionica = new TableColumn<>("Ucionica");
        tcUcionica.setCellValueFactory(new PropertyValueFactory<>("ucionica"));

        TableColumn<Ucionica,String> tcGrupe = new TableColumn<>("Grupe");
        tcGrupe.setCellValueFactory(new PropertyValueFactory<>("grupe"));

        TableColumn<Ucionica,String> tcPocetak = new TableColumn<>("Pocetak");
        tcPocetak.setCellValueFactory(new PropertyValueFactory<>("pocetak"));

        TableColumn<Ucionica,String> tcKraj = new TableColumn<>("Kraj");
        tcKraj.setCellValueFactory(new PropertyValueFactory<>("kraj"));

        tvUcionica.getColumns().addAll(tcPredmet,tcNastavnik,tcVrsta,tcDan,tcUcionica,tcGrupe,tcPocetak,tcKraj);
        tvUcionica.getItems().addAll(FXCollections.observableArrayList(Server.getInstance().getSveUcionice()));
        tvUcionica.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    private void initHBoxMid(){
        hBoxObracun = new HBox();
        btnObracunaj = new Button("Obracunaj po ucionicama");
        hBoxObracun.getChildren().add(btnObracunaj);
        hBoxObracun.setAlignment(Pos.BASELINE_CENTER);
    }

    private void sastavi(){
        vBoxGlavni.getChildren().addAll(hBoxTop,tvUcionica,hBoxObracun,tvTermini,hBoxSacuvaj);
        vBoxGlavni.setSpacing(15);
        vBoxGlavni.setPadding(new Insets(15,0,15,0));
    }

    private void actions(){
        btnSacuvaj.setOnAction(event -> {
            FileUtil.writeStuff("sacuvani.txt");
            System.out.println("Stampam pare");
        });

        btnObracunaj.setOnAction(event -> {
            for(Ucionica ucionica : tvUcionica.getSelectionModel().getSelectedItems()) {
                Termin termin = new Termin(ucionica.getUcionica(), "[ " + ucionica.getPocetak() + " " + ucionica.getKraj() + "]", ucionica.getGrupe());
                Server.getInstance().getSviTermini().add(termin);
                System.out.println(termin);
            }
            tvTermini.getItems().addAll(FXCollections.observableList(Server.getInstance().getSviTermini()));
            tvTermini.refresh();
        });


        btnFIltriraj.setOnAction(event -> {
            String selektovanCombo = cmbDani.getSelectionModel().getSelectedItem();
            String upisanOd = tfOd.getText();
            String upisanDo = tfdDo.getText();
            List<Ucionica> zadovoljavaju = new ArrayList<>();
            for (Ucionica ucionica : Server.getInstance().getSveUcionice()){
                if (ucionica.getDan().equals(selektovanCombo) || ucionica.getPocetak().equals(upisanOd) || ucionica.getKraj().equals(upisanDo)){
                    zadovoljavaju.add(ucionica);
                }
            }
            tvUcionica.getItems().clear();
            tvUcionica.getItems().addAll(FXCollections.observableArrayList(zadovoljavaju));
            tvUcionica.refresh();
        });


        btnPrikazi.setOnAction(event -> {
            tvUcionica.getItems().clear();
            tvUcionica.getItems().addAll(FXCollections.observableList(Server.getInstance().getSveUcionice()));
        });
    }


    private void initTable2(){
        tvTermini = new TableView<>();
        TableColumn<Termin,String> tcUcionica = new TableColumn<>("Ucionica");
        tcUcionica.setCellValueFactory(new PropertyValueFactory<>("ucionicaTermina"));

        TableColumn<Termin,String> tcZauzetiTemini = new TableColumn<>("Zauzeti termini");
        tcZauzetiTemini.setCellValueFactory(new PropertyValueFactory<>("zauzetiTermin"));

        TableColumn<Termin,String> tcGrupe = new TableColumn<>("Grupe");
        tcGrupe.setCellValueFactory(new PropertyValueFactory<>("grupeTermina"));

        tvTermini.getColumns().addAll(tcUcionica,tcZauzetiTemini,tcGrupe);
        tvTermini.getItems().addAll(FXCollections.observableList(Server.getInstance().getSviTermini()));
    }

    private void initHboxLow(){
        hBoxSacuvaj = new HBox();
        btnSacuvaj = new Button("Sacuvaj");
        hBoxSacuvaj.getChildren().addAll(btnSacuvaj);
        hBoxSacuvaj.setAlignment(Pos.BASELINE_CENTER);
    }



    public static MainView getInstance(){
        if(instance == null)
            instance = new MainView();
        return instance;
    }


}
