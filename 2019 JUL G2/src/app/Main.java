package app;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Server;
import util.FileUtil;
import view.MainView;

public class Main extends Application {

    public static void main(String[] args) {
        Server.getInstance();
        FileUtil.readFile("raspored.txt");
        launch(args);
    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        MainView.getInstance().show();
    }
}
