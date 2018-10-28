package ui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import work.Translator;

import java.io.IOException;

public class Menu extends SceneLayout {

    public static void display(Stage window) {
        window.setTitle("Translator");

        VBox vBox= new VBox(10);
        vBox.setAlignment(Pos.CENTER);

        Label testLabel = new Label("NAPA/UMISTA TRANSLATOR");
        Label descriptionLabel = new Label("Created by Melissa Bernstein, 2018");

        try {
            Translator.loadEquivalences("equivalencyKey.txt");
        } catch (IOException e1) {
            System.out.println("Input file not found.");
        }

        Button loadFromFile = new Button("Load from File");
        loadFromFile.setOnAction(e -> {
            try {
                Translator.run();
            } catch (IOException e1) {
                System.out.println("Input file not found.");
            }
        });

        Button smallTranslatorButton = new Button("Translate a single word");
        smallTranslatorButton.setOnAction(e -> {
            SmallTranslator.display(window);
        });

        //TODO add toggle group (or like circle buttons (click on "NAPA --> Umista" or "Umista --> NAPA")

        vBox.getChildren().addAll(testLabel, descriptionLabel, loadFromFile, smallTranslatorButton);

        setScene(vBox, window);
    }
}
