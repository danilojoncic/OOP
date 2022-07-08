package app;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Server;
import util.FileUtil;
import view.FirstView;

public class Main extends Application {

    public static void main(String[] args) {
        Server.getInstance();
        FileUtil.ucitajZanimanje("zanimanja.txt");
        FileUtil.ucitajZaposlenog("zaposleni.txt");
        launch(args);
    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        FirstView.getInstance().show();

    }
}
