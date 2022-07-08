package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class FirstView extends Stage {
    //singleton
    public static FirstView instance = null;
    private Label lblUputstva;
    private GridPane gpUnos;
    private VBox vBoxGlavni;
    private TextField tfBtTermina;
    private TextField tfBrStudenata;
    private CheckBox cbRacunar;
    private Button btnPokreni;
    private Label lblPoruka;
    private HBox hbCb;
    private HBox hbBtn;
    private HBox hbLbl;
    private HBox hbUputstva;
    private FirstView(){
        init();
        sastavi();
        actions();
        setScene(new Scene(vBoxGlavni,350,350));
        setTitle("OOP 2021 JUN1 FirstView");
        show();

    }

    private void init(){
        vBoxGlavni = new VBox(10);
        lblUputstva = new Label("Unesite potrebne podatke za raspodelu");
        lblPoruka = new Label("Poruka");
        gpUnos = new GridPane();
        tfBrStudenata = new TextField();
        tfBtTermina = new TextField();
        cbRacunar = new CheckBox(" samo ucionice sa racunarima");
        btnPokreni = new Button("Pokreni");
        hbBtn = new HBox();
        hbCb = new HBox();
        hbLbl = new HBox();
        hbUputstva = new HBox();
    }

    public void sastavi(){


        hbUputstva.getChildren().add(lblUputstva);
        hbUputstva.setAlignment(Pos.CENTER);



        gpUnos.add(new Label("Broj termina :"),0,0);
        gpUnos.add(tfBtTermina,2,0,3,1);
        gpUnos.add(new Label("Broj studenata u ucionici : "),0,1,2,1);
        gpUnos.add(tfBrStudenata,2,1,3,1);
        gpUnos.setVgap(10);

        gpUnos.setAlignment(Pos.CENTER);

        hbCb.getChildren().add(cbRacunar);
        hbCb.setAlignment(Pos.CENTER);

        hbBtn.getChildren().add(btnPokreni);
        hbBtn.setAlignment(Pos.CENTER);

        hbLbl.getChildren().add(lblPoruka);
        hbLbl.setAlignment(Pos.CENTER);

        vBoxGlavni.getChildren().addAll(hbUputstva,gpUnos,hbCb,hbBtn,hbLbl);
        vBoxGlavni.setAlignment(Pos.CENTER);
        vBoxGlavni.setSpacing(10);
        vBoxGlavni.setPadding(new Insets(40,20,40,20));
    }

    private void actions(){
        btnPokreni.setOnAction(event -> {
            if (tfBrStudenata.getText().equals("") || tfBtTermina.equals("")){
                lblPoruka.setText("Alo Travolta iz Borce, unesi sve!");
                return;
            }

            if(Integer.parseInt(tfBrStudenata.getText()) <= 15 && Integer.parseInt(tfBtTermina.getText()) <= 3){
                MainView.getInstance().show();
                this.close();
            }

        });
    }


    public static FirstView getInstance(){
        if(instance == null)
            instance = new FirstView();
        return instance;
    }
}
