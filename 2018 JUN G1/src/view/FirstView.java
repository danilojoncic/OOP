package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Mec;
import model.Server;

import java.util.Map;

public class FirstView extends VBox {

    private HBox hBoxTop;
    private Label lblGrupa;
    private ComboBox<String> cmbGrupa;
    private Button btnFiltriraj;
    private Button btnPrikaziSve;
    private TableView<Mec> tvMec;
    private Button btnStatistika;
    private GridPane gpStatistika;
    private Label lblUkuonoGolova;
    private TextField tfUkupnogolova;
    private Label lblTim1Gol;
    private TextField tfTim1Gol;
    private Label lblGolRazlika;
    private TextField tfGolRazlika;
    private Label lblNeresenih;
    private TextField tfNeresenih;
    private Button btnUkrstanje;




    public FirstView(){
        initHbox();
        initTabela();
        initGridPane();
        initActions();
    }
    private void initHbox() {
        lblGrupa = new Label("Grupe");
        cmbGrupa = new ComboBox<>();
        cmbGrupa.getItems().addAll(Server.getInstance().getGrupe());
        btnFiltriraj = new Button("Filtriraj");
        btnPrikaziSve = new Button("Prikazi sve");
        hBoxTop = new HBox(lblGrupa,cmbGrupa,btnFiltriraj,btnPrikaziSve);
        hBoxTop.setAlignment(Pos.CENTER);
        hBoxTop.setPadding(new Insets(10));
        hBoxTop.setSpacing(5);
        this.getChildren().add(hBoxTop);
    }

    private void initTabela(){
        tvMec = new TableView<>();
        TableColumn<Mec,String> tcTim1 = new TableColumn<>("Tim1");
        tcTim1.setCellValueFactory(new PropertyValueFactory<>("tim1"));

        TableColumn<Mec,String> tcTim2 = new TableColumn<>("Tim2");
        tcTim2.setCellValueFactory(new PropertyValueFactory<>("tim2"));

        TableColumn<Mec,Integer> tcGolovi1 = new TableColumn<>("Golovi tim 1");
        tcGolovi1.setCellValueFactory(new PropertyValueFactory<>("goloviTim1"));

        TableColumn<Mec,Integer> tcGolovi2 = new TableColumn<>("Golovi tim 2");
        tcGolovi2.setCellValueFactory(new PropertyValueFactory<>("goloviTim2"));

        TableColumn<Mec,String> tcGrupa = new TableColumn<>("Grupa");
        tcGrupa.setCellValueFactory(new PropertyValueFactory<>("grupa"));

        tvMec.getColumns().addAll(tcTim1,tcTim2,tcGolovi1,tcGolovi2,tcGrupa);
        tvMec.setPrefHeight(250);
        tvMec.getItems().addAll(Server.getInstance().sviMecevi);
        this.getChildren().add(tvMec);


        btnStatistika = new Button("Statistika");
        btnStatistika.setAlignment(Pos.CENTER);
        HBox hBoxStats = new HBox(btnStatistika);
        hBoxStats.setPadding(new Insets(15));
        btnStatistika.setAlignment(Pos.CENTER);
        this.getChildren().add(hBoxStats);
        hBoxStats.setAlignment(Pos.CENTER);

    }


    private void initGridPane() {
        lblUkuonoGolova = new Label("Ukupno golova");
        tfUkupnogolova = new TextField();
        lblTim1Gol = new Label("Tim sa najvise datih golova");
        tfTim1Gol = new TextField();
        lblGolRazlika = new Label("Tim sa najboljom gol razlikom");
        tfGolRazlika = new TextField();
        lblNeresenih = new Label("Broj neresenih utakmica");
        tfNeresenih = new TextField();

        gpStatistika = new GridPane();
        gpStatistika.setAlignment(Pos.CENTER);
        gpStatistika.addRow(0,lblUkuonoGolova,tfUkupnogolova);
        gpStatistika.addRow(1,lblTim1Gol,tfTim1Gol);
        gpStatistika.addRow(2,lblGolRazlika,tfGolRazlika);
       // gpStatistika.addRow(3,tfNeresenih,tfNeresenih);

        gpStatistika.setPadding(new Insets(10));
        this.getChildren().add(gpStatistika);
        gpStatistika.setHgap(10);
        gpStatistika.setVgap(10);



        btnUkrstanje = new Button("Ukrstanje");
        HBox hboxMid = new HBox(btnUkrstanje);
        this.getChildren().add(hboxMid);
        hboxMid.setPadding(new Insets(10));
        hboxMid.setAlignment(Pos.CENTER);
        btnUkrstanje.setAlignment(Pos.CENTER);

    }

    private void initActions() {
        btnUkrstanje.setOnAction(event -> {
            System.out.println("Prikazi");
        });

        btnStatistika.setOnAction(event -> {
            System.out.println("Izbacujem statistiku");
            SecondView.getInstance();
            
        });

        btnPrikaziSve.setOnAction(event -> {
            System.out.println("Prikazujem sve");
        });

        btnFiltriraj.setOnAction(event -> {
            System.out.println("Filtriram");
        });


        int brojGolova = 0;
        for (Mec mec : Server.getInstance().sviMecevi){
            int zbir = mec.getGoloviTim1() + mec.getGoloviTim2();
            brojGolova += zbir;
        }
        tfUkupnogolova.setText(brojGolova + " " );




    }






}
