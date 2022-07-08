package app;


import javafx.application.Application;
import javafx.stage.Stage;
import model.Server;
import utils.FileUtil;
import view.FirstView;

public class Main extends Application {

    public static void main(String[] args) {
        Server.getInstance();
        FileUtil.loadStudents("studenti1.txt");
        FileUtil.loadClassrooms("ucionice1.txt");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FirstView.getInstance();

    }
}
