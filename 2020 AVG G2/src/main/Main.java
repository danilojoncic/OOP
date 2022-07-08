package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Server;
import utils.FileUtil;
import view.FirstView;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }




    @Override
    public void start(Stage primaryStage) throws Exception {
        Server.getInstance();
        FileUtil.ucitajFajl("udzbenici-drugi termin.txt");
        primaryStage.setTitle("OOP Avgust 2020 G2");
        FirstView fw = new FirstView();
        primaryStage.setScene(new Scene(fw,800,600));
        primaryStage.show();
    }
}
