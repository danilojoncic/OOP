package view;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Server;
import model.Termin;
import model.Ucionica;
import utils.FileUtil;

import java.security.spec.RSAPrivateKeySpec;


public class FirstView extends Stage {
    public static FirstView instance = null;
    private VBox vBoxGlavni;
    private HBox hBoxTop;
    private Button btnPrebaci;
    private Button btnSacuvaj;
    private TableView<Termin> tvTermin;
    private GridPane gpLow;
    private Label lblNoviTermin;
    private TextField  tfUnesi;
    private ListView<Ucionica> lvUcionice;
    private Button btnDodaj;

    private FirstView(){
        setTitle("OOP JUN G1 2021");
        init();
        sastaviTop();
        sastaviLow();
        sastavi();
        actions();
        setScene(new Scene(vBoxGlavni,600,600));

    }
    private void init(){
        vBoxGlavni = new VBox();
        hBoxTop = new HBox();
        tvTermin = new TableView<>();
        btnDodaj = new Button("Dodaj");
        btnSacuvaj = new Button("Sacuvaj");
        btnPrebaci = new Button("Prebaci");
        gpLow = new GridPane();
        lblNoviTermin = new Label("Novi termin");
        tfUnesi = new TextField();
        lvUcionice = new ListView<>(FXCollections.observableList(Server.getInstance().getSveUcionice()));
    }

    private void sastaviTop(){
        hBoxTop.getChildren().addAll(btnPrebaci,btnSacuvaj);
        vBoxGlavni.getChildren().add(hBoxTop);
        hBoxTop.setAlignment(Pos.BASELINE_RIGHT);
        hBoxTop.setSpacing(5);

        TableColumn<Termin,String> tcUcionica = new TableColumn<>("Ucionica");
        tcUcionica.setCellValueFactory(new PropertyValueFactory<>("ucionica"));

        TableColumn<Termin,Integer> tcVreme = new TableColumn<>("Termin");
        tcVreme.setCellValueFactory(new PropertyValueFactory<>("vreme"));

        TableColumn<Termin,Integer> tcBrojSt = new TableColumn<>("BrojStudenata");
        tcBrojSt.setCellValueFactory(new PropertyValueFactory<>("brojStudenata"));

        TableColumn<Termin,Integer> tcPrekoracenje = new TableColumn<>("Prekoracenje");
        tcPrekoracenje.setCellValueFactory(new PropertyValueFactory<>("prekoracenje"));

        TableColumn<Termin,Integer> tcSlobodno = new TableColumn<>("Slobodno");
        tcSlobodno.setCellValueFactory(new PropertyValueFactory<>("slobodno"));

        tvTermin.getColumns().addAll(tcUcionica,tcVreme,tcBrojSt,tcPrekoracenje,tcSlobodno);
        tvTermin.getItems().addAll(Server.getInstance().getSviTermini());
        vBoxGlavni.getChildren().add(tvTermin);
    }

    private void sastaviLow(){
        gpLow.add(lblNoviTermin,0,0,1,1);
        gpLow.add(tfUnesi,1,0,4,1);
        gpLow.add(new Label("Ucionice"),0,2,1,1);
        gpLow.add(lvUcionice,1,1,4,2);
        gpLow.add(btnDodaj,1,3,1,1);
        gpLow.setVgap(20);
        gpLow.setHgap(10);
        lvUcionice.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        vBoxGlavni.getChildren().add(gpLow);
    }

    private void actions(){
        btnPrebaci.setOnAction(event -> {
            SecondView.getInstance().show();
            this.close();
        });

        btnSacuvaj.setOnAction(event -> {
            FileUtil.writeStuff("snimljeno.txt");
        });

    }

    private void sastavi(){
        vBoxGlavni.setPadding(new Insets(20));
        vBoxGlavni.setSpacing(10);
    }



    public static FirstView getInstance(){
        if (instance == null)
            instance = new FirstView();
        return instance;
    }


}
