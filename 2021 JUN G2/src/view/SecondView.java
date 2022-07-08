package view;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Server;
import model.Student;

public class SecondView extends Stage {
    public static SecondView instance = null;
    private VBox vBoxGlavni;
    private Label lblInfo;
    private ListView<Student> lvStudenti;
    private GridPane gp;
    private Label lblTermin;
    private Label lblUcionica;
    private ComboBox<Integer> cmbTermini;
    private ComboBox<String> cmbUcionice;
    private Button btnPrebaci;
    private Label lblPoruka;

    private HBox hBoxTekst;
    private HBox hBoxGp;
    private SecondView(){
        setTitle("OOP JUN2 2021 SecondView");
        init();
        sastavi();
        actions();
        setScene(new Scene(vBoxGlavni,600,400));
    }

    private void init(){
        vBoxGlavni = new VBox();
        hBoxGp = new HBox();
        hBoxTekst = new HBox();
        gp = new GridPane();
        lblInfo = new Label("Ucionica: ////, termin: //, prekoraceno: 5");
        lvStudenti = new ListView<>(FXCollections.observableList(Server.getInstance().getSviStudenti()));
        lblPoruka = new Label("Poruka");
        lblTermin = new Label("Termin");
        lblUcionica = new Label("Ucionica");
        cmbTermini = new ComboBox<>();
        cmbUcionice = new ComboBox<>();
        btnPrebaci = new Button("Prebaci");
    }
    private void sastavi(){
        lvStudenti.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lvStudenti.setMaxHeight(200);
        cmbUcionice.getItems().addAll(Server.getInstance().getSviNaziviUcionica());
        cmbUcionice.setValue("RAF1");

        cmbTermini.getItems().addAll(Server.getInstance().getSvoVreme());
        cmbTermini.setValue(15);
        gp.add(lblTermin,0,0);
        gp.add(cmbTermini,1,0);
        gp.add(lblUcionica,0,1);
        gp.add(cmbUcionice,1,1);
        gp.add(btnPrebaci,1,2);
        gp.add(lblPoruka,1,3);
        gp.setVgap(15);
        gp.setHgap(15);

        hBoxGp.getChildren().add(gp);
        hBoxGp.setAlignment(Pos.CENTER);

        hBoxTekst.getChildren().add(lblInfo);
        hBoxTekst.setAlignment(Pos.CENTER);

        vBoxGlavni.getChildren().addAll(hBoxTekst,lvStudenti,hBoxGp);
        vBoxGlavni.setSpacing(15);
        vBoxGlavni.setPadding(new Insets(25));



    }


    private void actions(){
        btnPrebaci.setOnAction(event -> {
            this.close();
            FirstView.getInstance().show();
        });
    }





    public static SecondView getInstance(){
        if(instance == null)
            instance = new SecondView();
        return instance;
    }
}
