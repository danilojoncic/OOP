package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Server;
import utils.FileUtil;
import view.FirstView;

public class Main extends Application {


    public static void main(String[] args) {
        //FileUtil.ucitajFajl("sp.txt");

        launch(args);

    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        Server.getInstance();
        FileUtil.ucitajFajl("sp.txt");
        primaryStage.setTitle("OOP prvi pokusaj");
        FirstView fw = new FirstView();
        primaryStage.setScene(new Scene(fw,600,500));
        primaryStage.show();






    }
}
