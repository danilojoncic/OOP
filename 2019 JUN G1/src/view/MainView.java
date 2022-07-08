package view;

import javafx.collections.FXCollections;
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

public class MainView extends Stage {
    public static MainView instance = null;
    private VBox vBoxGlavni;
    private static TableView<Student> tvStudent;
    private HBox hBoxTop;
    private HBox hBoxLow;
    private ListView<String> lvMail;
    private ListView<Student> lvStudenti;
    private VBox vBoxMid;
    private Button btnUpari;
    private VBox vBoxListaIFilter;
    private HBox hBoxFilter;
    private TextField tfFilter;
    private Button btnFilter;

    private Button btnSnimi;

    private MainView(){
        vBoxGlavni = new VBox();
        setTitle("OOP 2019 Jun G1");
        initTable();
        initVboxUnutrasnji();
        initVboxDugme();
        initHboxTop();
        initHboxLow();
        sastavi();
        actions();
        setScene(new Scene(vBoxGlavni,700,500));
    }

    private void initTable(){
        tvStudent = new TableView<>();
        TableColumn<Student,String> tcIme = new TableColumn<>("Ime");
        tcIme.setCellValueFactory(new PropertyValueFactory<>("ime"));

        TableColumn<Student,String> tcPrezime = new TableColumn<>("Prezime");
        tcPrezime.setCellValueFactory(new PropertyValueFactory<>("prezime"));

        TableColumn<Student,Integer> tcGodina = new TableColumn<>("Godina");
        tcGodina.setCellValueFactory(new PropertyValueFactory<>("godUpisa"));

        TableColumn<Student,Integer> tcBroj = new TableColumn<>("Broj");
        tcBroj.setCellValueFactory(new PropertyValueFactory<>("redniBroj"));

        TableColumn<Student,String> tcSmer = new TableColumn<>("Smer");
        tcSmer.setCellValueFactory(new PropertyValueFactory<>("smer"));

        TableColumn<Student,Integer> tcPitanje1 = new TableColumn<>("Pitanje1");
        tcPitanje1.setCellValueFactory(new PropertyValueFactory<>("bod1"));

        TableColumn<Student,Integer> tcPitanje2 = new TableColumn<>("Pitanje2");
        tcPitanje2.setCellValueFactory(new PropertyValueFactory<>("bod2"));

        TableColumn<Student,Integer> tcPitanje3 = new TableColumn<>("Pitanje3");
        tcPitanje3.setCellValueFactory(new PropertyValueFactory<>("bod3"));

        tvStudent.getColumns().addAll(tcIme,tcPrezime,tcSmer,tcBroj,tcGodina,tcPitanje1,tcPitanje2,tcPitanje3);
        tvStudent.getItems().addAll(Server.getInstance().getSviStudenti());
        tvStudent.setMaxWidth(630);
    }


    private void initVboxUnutrasnji(){
        vBoxListaIFilter = new VBox(15);
        lvStudenti = new ListView<>();
        lvStudenti.getItems().addAll(Server.getInstance().getSviStudenti());
        hBoxFilter = new HBox(15);
        tfFilter = new TextField();
        btnFilter = new Button("Filtriraj");
        hBoxFilter.getChildren().addAll(new Label("Filter"),tfFilter,btnFilter);
        vBoxListaIFilter.getChildren().addAll(hBoxFilter,lvStudenti);
        vBoxListaIFilter.setSpacing(15);
    }


    private void initVboxDugme(){
        vBoxMid = new VBox();
        btnUpari = new Button("Upari");
        vBoxMid.getChildren().add(btnUpari);
        vBoxMid.setAlignment(Pos.CENTER);
    }

    private void initHboxTop(){
        lvMail = new ListView<>();
        lvMail.getItems().addAll(FXCollections.observableList(Server.getInstance().getSviMejlovi()));
        hBoxTop = new HBox(40);
        hBoxTop.getChildren().addAll(vBoxListaIFilter,vBoxMid,lvMail);
    }


    private void initHboxLow(){
        hBoxLow = new HBox(15);
        btnSnimi = new Button("Snimi");
        hBoxLow.getChildren().add(btnSnimi);
        hBoxLow.setAlignment(Pos.BASELINE_CENTER);
    }

    private void sastavi(){
        vBoxGlavni.getChildren().addAll(tvStudent,hBoxTop,hBoxLow);
        vBoxGlavni.setSpacing(15);
        vBoxGlavni.setPadding(new Insets(30));
    }


    private void actions(){
        System.out.println("RESI");
        btnSnimi.setOnAction(event -> {





        });


    }




    public static MainView getInstance(){
        if (instance == null)
            instance = new MainView();
        return instance;


    }



}
