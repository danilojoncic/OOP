package view;

import javafx.stage.Stage;

public class SecondView extends Stage {

    public static SecondView instance = new SecondView();
    private SecondView(){
        show();

    }

    public static SecondView getInstance(){
        if(instance == null)
            instance = new SecondView();
        return instance;
    }


}
