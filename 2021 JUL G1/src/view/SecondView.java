package view;

import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Isplata;
import model.Server;
import model.Transakcija;

public class SecondView extends Stage {
    public static SecondView instance = null;
    private BorderPane bpGlavni;
    private GridPane gp;
    private Label lblIznos;
    private Label lblPrimalac;
    private Label lblKategorija;
    private TextField tfIznos;
    private TextField tfPrimalac;
    private ComboBox<String> cmbKategorija;
    private Button btnPlati;
    private SecondView(){
        setTitle("SecondView");
        init();
        actions();
        setScene(new Scene(gp,250,200));

    }


    private void init(){
        gp = new GridPane();
        lblIznos = new Label("Iznos");
        lblPrimalac = new Label("Primalac");
        lblKategorija = new Label("Kategorija");
        btnPlati = new Button("Plati");
        tfIznos = new TextField();
        tfPrimalac = new TextField();
        cmbKategorija = new ComboBox<>();
        cmbKategorija.getItems().addAll(Server.getInstance().getSveKategorije());
        cmbKategorija.setValue("EDUKACIJA");

        gp.add(lblIznos,0,0);
        gp.add(tfIznos,1,0,3,1);
        gp.add(lblPrimalac,0,1);
        gp.add(tfPrimalac,1,1,3,1);
        gp.add(lblKategorija,0,2);
        gp.add(cmbKategorija,1,2,3,1);
        gp.add(btnPlati,0,3);
        gp.setVgap(15);
        gp.setHgap(15);



        gp.setAlignment(Pos.CENTER);


    }

    private void actions(){
        btnPlati.setOnAction(event -> {
            int iznos = Integer.parseInt(tfIznos.getText());
            String osoba = tfPrimalac.getText();
            String izbor = cmbKategorija.getSelectionModel().getSelectedItem();
            Transakcija transakcija = new Isplata(iznos,osoba,"7.2.2022","ISPLATA", izbor);
            Server.getInstance().getSveTransakcije().add(transakcija);

            FirstView.getTvTransakcija().refresh();
           this.close();

        });
    }



    public static SecondView getInstance(){
        if (instance == null)
            instance = new SecondView();
        return instance;
    }


    public BorderPane getBpGlavni() {
        return bpGlavni;
    }

    public GridPane getGp() {
        return gp;
    }

    public Label getLblIznos() {
        return lblIznos;
    }

    public Label getLblPrimalac() {
        return lblPrimalac;
    }

    public Label getLblKategorija() {
        return lblKategorija;
    }

    public TextField getTfIznos() {
        return tfIznos;
    }

    public TextField getTfPrimalac() {
        return tfPrimalac;
    }

    public ComboBox<String> getCmbKategorija() {
        return cmbKategorija;
    }

    public Button getBtnPlati() {
        return btnPlati;
    }
}
