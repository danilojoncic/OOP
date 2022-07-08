package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.PipedReader;

public class PitanjeView extends Stage {
    //Singleton
    public static PitanjeView instance = null;
    private Label lblPitanje;
    private Label lblTekst;
    private Label lblOdgovor;
    private TextField tfOdgovor;
    private Button btnDalje;
    private VBox vBoxGlavni;
    private void init(){
        vBoxGlavni = new VBox();
        lblPitanje = new Label("Pitanje");
        lblTekst = new Label("ovo ne znam kako da implementiram");
        lblOdgovor = new Label("Odgovor");
        btnDalje = new Button("Dalje");
        tfOdgovor = new TextField();
        tfOdgovor.setPrefColumnCount(8);
        vBoxGlavni.getChildren().addAll(lblPitanje,lblTekst,lblOdgovor,tfOdgovor,btnDalje);
        //vBoxGlavni.setAlignment(Pos.CENTER);
        vBoxGlavni.setSpacing(15);
        vBoxGlavni.setPadding(new Insets(15));
        lblPitanje.setAlignment(Pos.CENTER_LEFT);
        lblTekst.setAlignment(Pos.CENTER_LEFT);
        lblOdgovor.setAlignment(Pos.CENTER_LEFT);
        btnDalje.setAlignment(Pos.CENTER);
    }


    private void actions(){
        btnDalje.setOnAction(event -> {
            if (tfOdgovor.getText().equals(""))
                System.err.println("Moras unijeti nesto u TextField");
            else System.out.println("Idemo dalje");
            tfOdgovor.clear();
        });
    }
    private PitanjeView(){

        setTitle("Odgovori na pitanje");
        init();

        Scene scene = new Scene(vBoxGlavni,500,200);
        setScene(scene);

        actions();

        show();

    }



    public static PitanjeView getInstance() {
            if(instance == null)
                instance = new PitanjeView();
            return instance;
    }

}
