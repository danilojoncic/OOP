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
import model.Zanimanje;
import model.Zaposlen;
import util.FileUtil;

public class FirstView extends Stage {
    public static FirstView instance = null;
    private VBox vBoxGlavni;
    private HBox hBoxTop;
    private TableView<Zaposlen> tvZaposleni;
    private HBox hBoxMid;
    private HBox hBoxLow;
    private Label lblCenaRada;
    private TextField tfCenaRada;
    private Button btnObracunaj;
    private Label lblFilter;
    private TextField tfFilter;
    private Label lblPozicija;
    private ComboBox<String> cmbString;
    private Button btnFiltriarj;
    private Button btnDodaj;
    private Button btnSnimi;
    private Button btnStatistika;
    private FirstView(){
        vBoxGlavni = new VBox();
        initTop();
        intiTable();
        initMid();
        initLow();
        actions();

        setTitle("OOP JUL G2 2021");
        setScene(new Scene(vBoxGlavni,600,350));
        vBoxGlavni.setPadding(new Insets(15,0,15,0));
        vBoxGlavni.setSpacing(15);

    }
    private void initTop(){
        hBoxTop = new HBox();
        lblCenaRada = new Label("Cena rada");
        tfCenaRada = new TextField();
        btnObracunaj = new Button("Obracunaj");
        hBoxTop.getChildren().addAll(lblCenaRada,tfCenaRada,btnObracunaj);
        hBoxTop.setAlignment(Pos.BASELINE_CENTER);
        vBoxGlavni.getChildren().add(hBoxTop);
        hBoxTop.setSpacing(15);
    }

    private void intiTable(){
        tvZaposleni = new TableView<>();
        TableColumn<Zaposlen,String> tcIme = new TableColumn<>("Ime");
        tcIme.setCellValueFactory(new PropertyValueFactory<>("ime"));

        TableColumn<Zaposlen,String> tcPrezime = new TableColumn<>("Prezime");
        tcPrezime.setCellValueFactory(new PropertyValueFactory<>("prezime"));

        TableColumn<Zaposlen,Long> tcJMBG = new TableColumn<>("JMBG");
        tcJMBG.setCellValueFactory(new PropertyValueFactory<>("JMBG"));

        TableColumn<Zaposlen, Zanimanje> tcPozicija = new TableColumn<>("Pozicija");
        tcPozicija.setCellValueFactory(new PropertyValueFactory<>("zanimanje"));

        TableColumn<Zaposlen,Double> tcPlata = new TableColumn<>("Plata");
        tcPlata.setCellValueFactory(new PropertyValueFactory<>("plata"));

        tvZaposleni.getColumns().addAll(tcIme,tcPrezime,tcJMBG,tcPozicija,tcPlata);
        tvZaposleni.getItems().addAll(FXCollections.observableArrayList(Server.getInstance().getSviZaposleni()));
        vBoxGlavni.getChildren().add(tvZaposleni);
        tvZaposleni.setMaxHeight(200);
    }
    private void initMid(){
        hBoxMid = new HBox(15);
        lblFilter = new Label("Filter");
        tfFilter = new TextField();
        lblPozicija = new Label("Pozicija");
        cmbString = new ComboBox<>();
        btnFiltriarj = new Button("Filtriraj");

        hBoxMid.getChildren().addAll(lblFilter,tfFilter,lblPozicija,cmbString,btnFiltriarj);
        cmbString.getItems().addAll(Server.getInstance().getCMBsvaZanimanja());
        hBoxMid.setAlignment(Pos.BASELINE_CENTER);
        cmbString.getItems().add("Sve pozicije");
        cmbString.setValue("Sve pozicije");

        vBoxGlavni.getChildren().add(hBoxMid);
    }
    private void initLow(){
        hBoxLow = new HBox(25);
        btnDodaj = new Button("Dodaj zaposlenog");
        btnSnimi = new Button("Snimi");
        btnStatistika = new Button("Statistika");


        hBoxLow.getChildren().addAll(btnDodaj,btnSnimi,btnStatistika);
        hBoxLow.setAlignment(Pos.BASELINE_CENTER);
        vBoxGlavni.getChildren().add(hBoxLow);
    }

    private void actions(){
        btnSnimi.setOnAction(event -> {
            FileUtil.ispisiFajl("snimljeno.txt");
        });



        btnStatistika.setOnAction(event -> {
            ThirdView.getInstance().show();
        });


        btnFiltriarj.setOnAction(event -> {
            for (Zaposlen zaposlen : tvZaposleni.getItems()) {
                if (zaposlen.getPozicija().equals(tvZaposleni.getItems())){
                    ObservableList oblista = FXCollections.observableArrayList();
                    oblista.add(zaposlen);
                    tvZaposleni.getItems().clear();
                    tvZaposleni.getItems().addAll(oblista);
                    tvZaposleni.refresh();
                }
            }
        });

        btnDodaj.setOnAction(event -> {
            SecondView.getInstance().show();
        });
    }

    public VBox getvBoxGlavni() {
        return vBoxGlavni;
    }

    public HBox gethBoxTop() {
        return hBoxTop;
    }

    public TableView<Zaposlen> getTvZaposleni() {
        return tvZaposleni;
    }

    public HBox gethBoxMid() {
        return hBoxMid;
    }

    public HBox gethBoxLow() {
        return hBoxLow;
    }

    public Label getLblCenaRada() {
        return lblCenaRada;
    }

    public TextField getTfCenaRada() {
        return tfCenaRada;
    }

    public Button getBtnObracunaj() {
        return btnObracunaj;
    }

    public Label getLblFilter() {
        return lblFilter;
    }

    public TextField getTfFilter() {
        return tfFilter;
    }

    public Label getLblPozicija() {
        return lblPozicija;
    }

    public ComboBox<String> getCmbString() {
        return cmbString;
    }

    public Button getBtnFiltriarj() {
        return btnFiltriarj;
    }

    public Button getBtnDodaj() {
        return btnDodaj;
    }

    public Button getBtnSnimi() {
        return btnSnimi;
    }

    public Button getBtnStatistika() {
        return btnStatistika;
    }

    public static FirstView getInstance(){
        if (instance == null)
            instance = new FirstView();
        return instance;
    }
}
