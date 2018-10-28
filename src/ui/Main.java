package ui;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        window = primaryStage;

        Menu.display(window);
        window.show();
    }



}
