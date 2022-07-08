package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Server;
import model.Transakcija;
import utill.FileUtil;

public class FirstView extends Stage {
    public static FirstView instance = null;
    private VBox vBoxGlavni;
    private Label lblStanje;
    private HBox hBoxtop;
    private static TableView<Transakcija> tvTransakcija;
    private HBox hBoxLow;

    public static ObservableList<Transakcija> obTransakcije = FXCollections.observableList(Server.instance.getSveTransakcije());

    private Button btnNovaIsplata;
    private Button btnPregledIspita;
    private FirstView(){
        initTop();
        initTable();
        initLow();
        sastavi();
        actions();

        setTitle("OOP JUL G1 2021 FirstView");
        setScene(new Scene(vBoxGlavni,500,350));
    }
    private void initTop(){
        vBoxGlavni = new VBox();
        lblStanje = new Label("Trenutno stanje: " + Server.racunajStanje() + " RSD");
        hBoxtop = new HBox(lblStanje);
        hBoxtop.setAlignment(Pos.CENTER);
    }

    private void initTable(){

        tvTransakcija = new TableView<>();
        TableColumn<Transakcija,Integer> tcIznos = new TableColumn<>("Iznos");
        tcIznos.setCellValueFactory(new PropertyValueFactory<>("iznos"));

        TableColumn<Transakcija,String> tcPrimalac = new TableColumn<>("Uplatilac/Primalac");
        tcPrimalac.setCellValueFactory(new PropertyValueFactory<>("primalac"));

        TableColumn<Transakcija,String> tcDatum = new TableColumn<>("Datum");
        tcDatum.setCellValueFactory(new PropertyValueFactory<>("datum"));

        TableColumn<Transakcija,String> tcTip = new TableColumn<>("Tip");
        tcTip.setCellValueFactory(new PropertyValueFactory<>("tip"));

        tvTransakcija.getColumns().addAll(tcIznos,tcPrimalac,tcDatum,tcTip);
        tvTransakcija.setMaxHeight(250);
        tvTransakcija.getItems().addAll(obTransakcije);
    }

    private void initLow(){
        hBoxLow = new HBox();
        btnNovaIsplata = new Button("Nova isplata");
        btnPregledIspita = new Button("Pregled isplata");
        hBoxLow.getChildren().addAll(btnNovaIsplata,btnPregledIspita);
        hBoxLow.setSpacing(50);
        hBoxLow.setAlignment(Pos.CENTER);
    }

    private void sastavi(){
        vBoxGlavni.getChildren().addAll(hBoxtop,tvTransakcija,hBoxLow);
        vBoxGlavni.setAlignment(Pos.CENTER);
        vBoxGlavni.setSpacing(15);
        vBoxGlavni.setPadding(new Insets(15,0,15,0));
    }

    private void actions(){
        btnNovaIsplata.setOnAction(event -> {
            SecondView.getInstance().show();
        });

        btnPregledIspita.setOnAction(event -> {
            FileUtil.pisiFajl("Isplate.txt");
            ThirdView.getInstance().show();
        });
    }

    public static FirstView getInstance(){
        if (instance == null)
            instance = new FirstView();
        return instance;
    }

    public static ObservableList<Transakcija> getObTransakcije() {
        return obTransakcije;
    }

    public VBox getvBoxGlavni() {
        return vBoxGlavni;
    }

    public Label getLblStanje() {
        return lblStanje;
    }

    public HBox gethBoxtop() {
        return hBoxtop;
    }

    public static TableView<Transakcija> getTvTransakcija() {
        return tvTransakcija;
    }

    public HBox gethBoxLow() {
        return hBoxLow;
    }

    public Button getBtnNovaIsplata() {
        return btnNovaIsplata;
    }

    public Button getBtnPregledIspita() {
        return btnPregledIspita;
    }
}
