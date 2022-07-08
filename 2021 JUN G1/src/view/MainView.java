package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Server;
import model.Student;
import model.Termin;
import model.Ucionica;
import utils.FileUtil;

public class MainView extends Stage {

    public static MainView instance = null;
    private VBox vBoxGlavni;
    private ListView<Student> lvStudenti;
    private Button btnDodeli;
    private ListView<Ucionica> lvUcionice;
    private ComboBox<String> cmbTermini;
    private Button btnUcitaj;
    private TableView<Termin> tvTermini;
    private Button btnSnimi;
    private VBox vBoxLeft;
    private VBox vBoxRight;
    private HBox vBoxMid;
    private HBox hBoxTop;
    private HBox hBoxLow;
    private VBox vBoxLow;
    private HBox hBoxCmbIButton;
    private MainView(){
        vBoxGlavni = new VBox();
        sastavi();

        actions();

        setScene(new Scene(vBoxGlavni,700,600));
        setTitle("OOP JUN1 Main View");

    }

    private void actions() {

        btnSnimi.setOnAction(event -> {
            FileUtil.writeStuff("snimljeno.txt",tvTermini);
        });
        btnDodeli.setOnAction(event -> {
            tvTermini.getItems().add(new Termin(lvStudenti.getSelectionModel().getSelectedItem(),cmbTermini.getSelectionModel().getSelectedItem(),lvUcionice.getSelectionModel().getSelectedItem()));

        });
    }





    private void initVboxLow() {
        vBoxLow = new VBox();

        hBoxLow = new HBox();
        btnSnimi = new Button("Snimi");

        tvTermini = new TableView<>();
        TableColumn<Termin,Student> tcStudent = new TableColumn<>("Studnet");
        tcStudent.setCellValueFactory(new PropertyValueFactory<>("student"));

        TableColumn<Termin,String> tcTermin = new TableColumn<>("Termin");
        tcTermin.setCellValueFactory(new PropertyValueFactory<>("termin"));

        TableColumn<Termin,Ucionica> tcUcionica = new TableColumn<>("Ucionica");
        tcUcionica.setCellValueFactory(new PropertyValueFactory<>("ucionica"));
        tvTermini.getColumns().addAll(tcStudent,tcTermin,tcUcionica);
        tvTermini.getItems().addAll(Server.getInstance().getTermini());
        tvTermini.setMaxHeight(150);
        hBoxLow.getChildren().add(btnSnimi);
        btnSnimi.setAlignment(Pos.CENTER);
        hBoxLow.setAlignment(Pos.CENTER);

        vBoxLow.getChildren().addAll(tvTermini,hBoxLow);
    }
    private void initHboxTop() {
        vBoxRight = new VBox(5);
        vBoxLeft = new VBox(5);
        lvStudenti = new ListView<>();
        lvStudenti.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lvStudenti.getItems().addAll(Server.getInstance().getSviStudenti());
        vBoxLeft.getChildren().addAll(new Label("Broj nerasporedjenih studenata: 350 "),lvStudenti);
        hBoxCmbIButton = new HBox(5);
        cmbTermini = new ComboBox<>();
        cmbTermini.getItems().addAll("termin1","termin2","termin3");
        cmbTermini.setValue("termin1");
        btnUcitaj = new Button("Ucitaj za termin");
        lvUcionice = new ListView<>();
        lvUcionice.getItems().addAll(Server.getInstance().getSveUcionice());
        hBoxCmbIButton.getChildren().addAll(cmbTermini,btnUcitaj);
        vBoxRight.getChildren().addAll(hBoxCmbIButton,lvUcionice);
        vBoxMid = new HBox();
        btnDodeli = new Button("Dodeli");
        vBoxMid.getChildren().add(btnDodeli);
        btnDodeli.setAlignment(Pos.CENTER);
        vBoxMid.setAlignment(Pos.CENTER);
        btnDodeli.setAlignment(Pos.CENTER);
        hBoxTop = new HBox(20);
        hBoxTop.getChildren().addAll(vBoxLeft,vBoxMid,vBoxRight);
        hBoxTop.setAlignment(Pos.CENTER);
    }
    private void sastavi() {
        initVboxLow();
        initHboxTop();
        vBoxGlavni = new VBox(20);
        vBoxGlavni.getChildren().addAll(hBoxTop,vBoxLow);
        vBoxGlavni.setPadding(new Insets(15));
    }

    public static MainView getInstance(){
        if(instance == null)
            instance = new MainView();
        return instance;
    }
    //singleton
}
