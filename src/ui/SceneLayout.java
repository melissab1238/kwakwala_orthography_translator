package ui;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public abstract class SceneLayout {
    protected static final int WIDTH = 300;
    protected static final int HEIGHT = 300;

    public static void setScene(Pane p, Stage window){ //why does everything need to be static?
        Scene scene = new Scene(p, WIDTH, HEIGHT );
        //scene.getStylesheets().add("StyleSheet.css");
        window.setScene(scene);

    }

}
