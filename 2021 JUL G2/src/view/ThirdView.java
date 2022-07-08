package view;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Server;
import model.Zanimanje;
import model.Zaposlen;

public class ThirdView extends Stage {
    public static ThirdView instance = null;
    private VBox vBoxGlavni;
    private HBox hbLIst;

    private ListView<Zanimanje> lvZanimanje;

    private HBox hBoxTop;
    private HBox hBoxMid;
    private HBox hbLow;

    private ThirdView(){
        vBoxGlavni = new VBox(15);
        init();
        setTitle("ThirdView");
        setScene(new Scene(vBoxGlavni,400,400));

    }
    private void init(){
        hbLow = new HBox(new Label("Prosecna zarada po zaposlenom:"));
        hBoxMid = new HBox(new Label("Broj zaposlenih " + Server.getInstance().getSviZaposleni().size()));
        hBoxTop = new HBox(new Label("Ukupni mesecni izadanak po osnovu zarada"));

        lvZanimanje = new ListView<>();
        vBoxGlavni.setAlignment(Pos.BASELINE_CENTER);
        vBoxGlavni.setPadding(new Insets(15));
        vBoxGlavni.setSpacing(15);
        vBoxGlavni.getChildren().add(lvZanimanje);
        lvZanimanje.getItems().addAll(Server.getInstance().getSvaZanimanja());
        vBoxGlavni.getChildren().addAll(hBoxTop,hBoxMid,hbLow);
        vBoxGlavni.setAlignment(Pos.CENTER);
    }



    public static ThirdView getInstance(){
        if (instance == null)
            instance = new ThirdView();
        return instance;
    }
}
