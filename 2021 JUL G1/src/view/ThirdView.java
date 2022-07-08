package view;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Isplata;
import model.Server;

public class ThirdView extends Stage {
    public static ThirdView instance = null;
    private VBox vBoxGlavni;
    private Label lblMin;
    private HBox hBoxGornji;
    private HBox hBoxdonji;
    private HBox hBoxKraj;
    private Label lblMax;
    private ListView<Isplata> lvIsplate;
    private Button btnZatvori;
    private ThirdView(){
        vBoxGlavni = new VBox();
        setTitle("ThirdView");
        initTop();
        initList();
        initLow();
        sastavi();
        actions();
        setScene(new Scene(vBoxGlavni,300,500));






    }
    private void initTop(){
        lblMax = new Label("Maksimalna isplata");
        lblMin = new Label("Minimalna isplata");
        hBoxGornji = new HBox(lblMin);
        hBoxdonji = new HBox(lblMax);
        hBoxdonji.setAlignment(Pos.BASELINE_LEFT);
        hBoxGornji.setAlignment(Pos.BASELINE_LEFT);
    }

    private void initList(){
        lvIsplate = new ListView<>();
        lvIsplate.getItems().addAll(FXCollections.observableList(Server.getInstance().getSveIsplate()));
    }

    private void initLow(){
        hBoxKraj = new HBox();
        btnZatvori = new Button("Zatvori");
        hBoxKraj.getChildren().add(btnZatvori);
        hBoxKraj.setAlignment(Pos.BASELINE_CENTER);
    }

    private void sastavi(){
        vBoxGlavni.getChildren().addAll(hBoxGornji,hBoxdonji,lvIsplate,hBoxKraj);
        vBoxGlavni.setSpacing(15);
        vBoxGlavni.setPadding(new Insets(15));
    }

    private void actions(){
        btnZatvori.setOnAction(event -> {
            this.close();
        });
    }



    public static ThirdView getInstance(){
        if (instance == null)
            instance = new ThirdView();
        return instance;
    }
}
