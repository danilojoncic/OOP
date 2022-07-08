package app;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Server;
import util.FileUtil;
import view.MainView;

import java.io.File;

public class Main extends Application {

    public static void main(String[] args) {
        Server.getInstance();
        FileUtil.ucitajPitanje1("pitanje1.txt");
        FileUtil.ucitajPitanje2("pitanje2.txt");
        FileUtil.ucitajPitanje3("pitanje3.txt");
        FileUtil.ucitajStudenta("studenti.txt");
        launch(args);
    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        MainView.getInstance().show();
    }
}
