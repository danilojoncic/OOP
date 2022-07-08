package app;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Server;
import utils.FileUtil;
import view.MainView;

public class Main extends Application {
    public static void main(String[] args) {
        Server.getInstance();
        FileUtil.loadFile("pitanja.txt");
        launch(args);

    }




    @Override
    public void start(Stage primaryStage) throws Exception {
        MainView mw = new MainView();
        primaryStage.setTitle("OOP 2021 Avgust");
        primaryStage.setScene(new Scene(mw,850,400));
        primaryStage.show();
    }
}
