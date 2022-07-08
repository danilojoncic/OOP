package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;

public class SecondView extends Stage {


    public static SecondView instance;


    private Button btnUgasi;


    private SecondView() {

        btnUgasi = new javafx.scene.control.Button("Ugasi");
        this.setTitle("Drugi prozor");
        this.show();
        btnUgasi.setOnAction(event -> {
            this.close();

        });
        btnUgasi.setAlignment(Pos.CENTER);
        btnUgasi.setPadding(new Insets(10));
        HBox hBox = new HBox(btnUgasi);
        hBox.setAlignment(Pos.CENTER);

        this.setScene(new Scene(hBox,600,600));


    }

    public static SecondView getInstance() {
        if (instance == null)
            instance = new SecondView();
            return instance;



    }
}
